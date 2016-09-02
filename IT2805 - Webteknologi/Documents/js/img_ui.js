var elements, i, title, title, img, frame, d, x, y, w, e, g;

var pressedImg = function(elem) {
	var re = new RegExp('(\s*([^\w]|^)on([^\w]|$)\s*)', 'g');
	t = !re.test(elem.className);
	
	if (t) {
		for (i = 0; i < elements.length; i++) {
			removeClass(elements[i], 'on');
		}
		
		addClass(elem, 'on');
		
		title.innerHTML = elem.title;
		img.src = elem.src;
		img.alt = elem.alt;
		img.style.width = elem.style.width;
		img.style.height = elem.style.height;
		frame.className = 'frame';
		
		resizeImg(img);
		
		// Mobile fix
		var interval = setInterval(function () {
			resizeImg(img);
			clearInterval(interval);
		}, 20);
	} else {
		removeClass(elem, 'on');
	}
}

var resizeImg = function(elem) {
	if (elem.clientHeight > 0) {
		x = w.innerWidth || e.clientWidth || g.clientWidth;
		y = w.innerHeight|| e.clientHeight|| g.clientHeight;
        y -= 64;
		var ratioFrame = (x > 0 ? y/x : 1);
		
		var wImg = elem.clientWidth;
		var hImg = elem.clientHeight;
		var ratioImg = (wImg > 0 ? hImg/wImg : 1);
		var scale = .9;
		
		if (ratioFrame > ratioImg) {
			elem.style.width = (scale*x) + 'px';
			elem.style.height = (scale*x*ratioImg) + 'px';
            title.style.paddingTop = ((y-64) - (scale*x*ratioImg))/2 + 'px';
		} else {
			elem.style.width = (scale*y/ratioImg) + 'px';
			elem.style.height = (scale*y) + 'px';
            title.style.paddingTop = 0;
		}
	}
}

var addClass = function(elem, classname) {
	var re = new RegExp('(\s*([^\w]|^)'+classname+'([^\w]|$)\s*)', 'g');
	elem.className =  elem.className.replace(re, '') + ' '+classname+' ';
}

var removeClass = function(elem, classname) {
	var re = new RegExp('(\s*([^\w]|^)'+classname+'([^\w]|$)\s*)', 'g');
	elem.className =  elem.className.replace(re, '');
}

document.addEventListener('DOMContentLoaded', function () {
	d = document;
	w = window;
	e = d.documentElement;
	g = d.getElementsByTagName('body')[0];
	x = w.innerWidth || e.clientWidth || g.clientWidth;
	y = w.innerHeight|| e.clientHeight|| g.clientHeight;
	
	elements = d.getElementsByClassName('showoff');
	
	id = d.getElementsByTagName('body')[0];
	
	if (id !== null) {
		frame = d.createElement('div');
		frame.className = 'frame hidden';
		id.appendChild(frame);
		
		title = d.createElement('h1');
		title.className = 'frame';
		frame.appendChild(title);
		
		img = d.createElement('img');
		img.className = 'frame';
		img.src = '';
		frame.appendChild(img);
        
        for (i = 0; i < elements.length; i++) {
            if (elements[i].title != '') {
                fig = d.createElement('figcaption');
                fig.innerHTML = elements[i].title;
                elements[i].parentNode.insertBefore(fig, elements[i].nextSibling);
            }
        }
		
		frame.addEventListener('click', function (e) {
			frame.className = 'frame hidden';
			
			for (i = 0; i < elements.length; i++) {
				removeClass(elements[i], 'on');
			}
		});
		
		for (i = 0; i < elements.length; i++) {
			var elem = elements[i];
			
			elem.addEventListener('click', function (e) {
				pressedImg(this);
			});
		}
		
		window.addEventListener('resize', function (e) {
			resizeImg(img);
		});
	}
});
