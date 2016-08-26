/**
 * This is the main script for the site. Currently it needs to be placed on the
 * bottom of the site as it needs to reach the DOM elements after rendering.
 * I could wait for window load or document DOM, but that may wait for later.
 * 
 * The script is also inside an anonym functions which invokes it self. That is
 * because we do not want global variables and variables which mixes with other
 * scripts.
 * 
 * I am also using StandarsJS syntax with JSDoc comments like this.
 */

(function () {
  var d = document

  /**
   * Adding clickable buttons to elements with a .next-slide class.
   */
  var nextSlideBtns = d.querySelectorAll('.next-slide')
  var slides = d.querySelectorAll('.slide')
  for(var i = 0; i < nextSlideBtns.length; i++) {
    var _btn = nextSlideBtns[i]

    _btn.nextSlide = slides[Math.min(i + 1, slides.length - 1)]
    _btn.addEventListener('click', function () {
      if (typeof this.nextSlide === 'object')
        scrollTo(this.nextSlide, undefined, easeInOut)
    })
  }

  /**
   * Making the elements with the .play-music class play the .music-player
   * element.
   */
  var playBtns = d.querySelectorAll('.play-music')
  for(var i = 0; i < playBtns.length; i++) {
    var _btn = playBtns[i]

    _btn.addEventListener('click', function () {
      var _player = d.querySelector('#music-player')
      _player.play()
    })
  }

  /**
   * Scroll to element from an element with some kind of function.
   * 
   * @param {string} to Element to scroll to.
   * @param {string} from Element to scroll from.
   * @param {function} fn Function used to control animation. From x, get y.
   */
  function scrollTo(to, from, fn) {
    from = typeof from === 'object'
      ? from.offsetTop
      : (typeof from !== 'undefined'
        ? from
        : document.querySelector('body').scrollTop
      )
    to = typeof to === 'object'
      ? to.offsetTop
      : (typeof to !== 'undefined' ? to : 0)
    fn = typeof fn !== 'undefined'
      ? fn
      : function (x) { return x; }

    var _scrollBoard = document.querySelector('body')
    var _scrollStartPos = from
    var _scrollEndPos = to
    var _diff = _scrollStartPos - _scrollEndPos
    var _time = 1000
    var _process = 0

    var _interval = setInterval(function () {
      _process += 10/_time
      _scrollBoard.scrollTop = _scrollStartPos - _diff*fn(_process, 8)

      if (_process > 1) {
        clearInterval(_interval)
        _scrollBoard.scrollTop = _scrollEndPos
      }
    }, 1)
  }

  /**
   * Timeing function which can be used by the scrollTo function.
   * 
   * @param {number} process Number from 0-1, could be intepreted as 0% - 100%.
   */
  function easeInOut (process) {
    if (process < .5)
      return .5 - Math.pow(1 - 2*process, 1/3)*.5
    return Math.pow(2*process - 1, 1/3)*.5 + .5
  }

  /**
   * Timeing function which can be used by the scrollTo function. This is
   * a self made function using the tan trigonometric function as function.
   * 
   * @param {number} process Number from 0-1, could be intepreted as 0% - 100%.
   * @param {number} smoothness How smooth the slope/function should be.
   */
  function easeWithTan (process, smoothness) {
    smoothness = typeof smoothness !== 'undefined' && smoothness > 0
      ? smoothness
      : 2
    return (
      Math.atan(smoothness * (process - .5))
      + Math.atan(smoothness * .5)
    ) / (2 * Math.atan(smoothness * .5))
  }
}())
