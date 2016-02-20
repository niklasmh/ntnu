// Dette eksempelet skal gå etter Date() og vil derfor være korrekt med tiden. Å bare bruke setInterval() vil man få små følges feil, derfor bruker jeg dette.

// Her blir variablene satt slik at de blir globale og er lett tilgjengelig gjennom konsollen (da kan man debugge enklere):
var d = document,
    time = 0,
    starttime = new Date(),
    pausedtime = 0,
    ison = false,
    stopwatch;

// Jeg bruker document sin "DOMContentLoaded" istedet for window sin "load" fordi jeg ikke trenger å vente på at andre ressurser som css og img-tagger skal laste inn.
d.addEventListener('DOMContentLoaded', function (e) {
    
    // Nå kan elementene hentes ifra DOM og flere lyttere bli tilknyttet til knappene
	var area = d.getElementById('display-area'),
        toggle = d.getElementById('toggle-button'),
        reset = d.getElementById('reset-button');
    
	reset.addEventListener("click", function (e) {
        starttime = new Date();
		pausedtime = 0;
		time = 0;
		area.value = formatTime(time);
		//clearInterval(stopwatch); // Jeg stopper ikke klokka når "reset" trykkes fordi det ikke stod i oppgaven. Derfor er den kommentert ut.
	});
	
	toggle.addEventListener("click", function (e) {
		ison = !ison; // Gjør true til false og omvendt
		
		if (ison) {
			starttime = new Date();
			starttime -= pausedtime;
			stopwatch = setInterval(runwatch, 1);
		} else {
			pausedtime = new Date();
			pausedtime -= starttime;
			clearInterval(stopwatch);
		}
	});
	
	var runwatch = function () {
        var now = new Date();
		time = now - starttime;
		area.value = formatTime(time);
	}
	
    // Nå kan vi formatere en string med en enkel funksjon
	var formatTime = function (time) {
		var t = new Date(time);
		return dd(t.getUTCHours())
            + ':' + dd(t.getUTCMinutes())
            + ':' + dd(t.getUTCSeconds())
            + '.' + ddd(t.getUTCMilliseconds());
	}
    
    // Slik at vi får 2 siffer uansett, eller fler
    var dd = function (n) {
        return (n < 10 ? '0' : '') + n
    }
	
    // Slik at vi får 3 siffer uansett, eller fler
    var ddd = function (n) {
        return (n < 100 ? '0' : '') + (n < 10 ? '0' : '') + n
    }
});