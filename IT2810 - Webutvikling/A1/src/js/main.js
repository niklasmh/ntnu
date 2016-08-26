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

  var nextSlideBtns = d.querySelectorAll('.next-slide')
  for(var i = 0; i < nextSlideBtns; i++) {
    var _btn = nextSlideBtns[i]
    _btn.addEventListener('click', function () {
      // Do something
    })
  }
}())
