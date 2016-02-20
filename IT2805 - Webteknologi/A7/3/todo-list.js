// Jeg velger å lagre lista som en cookie.
// Denne cookien varer i 10 år og oppdateres til 10 år hver gang noe legges til.

var d = document, lstArr, last_id = 0, lstArr = [];

d.addEventListener('DOMContentLoaded', function () {
    var lst = d.getElementById('todo-lst'),
        btnClear = d.getElementById('clear-btn'),
        btnAdd = d.getElementById('add-btn'),
        txt = d.getElementById('todo-txt');
    
    
    var jsonObj = getCookie('list_data');
    lstArr = JSON.parse(jsonObj) || [];
    
    
    for (i in lstArr) {
        addElementFromInput(lstArr[i].text, lstArr[i].checked, lstArr[i].id);
        last_id = Math.max(last_id, lstArr[i].id);
    }
    
    
    // Så vi kan legge til med enter-tasten
    txt.addEventListener('keydown', function (e) {
        if (e.keyCode == 13 && txt.value.length > 0) {
            addElementFromInput();
            updateJsonCookie();
            
        }
    });
    
    // Så vi kan legge til med +-knappen
    btnAdd.addEventListener('click', function () {
        addElementFromInput();
        updateJsonCookie();
        
    });
    
    // Så vi kan fjerne de merkede
    btnClear.addEventListener('click', function () {
        var newRow = lst.querySelectorAll('li'),
            newArr = [];
        
        for (var i = 0; i < newRow.length; i++) {
            if (newRow[i].children[0].checked) {
                lst.removeChild(newRow[i]);
            } else {
                newArr.push(lstArr[i]);
            }
        }
        
        deleteCookie('list_data');
        lstArr = newArr;
        updateJsonCookie();
    });
    
    function addElementFromInput (newTxt, isChecked, id) {
        var isNewTxt = (typeof newTxt !== 'undefined' && newTxt.length > 0),
            txtInst = (isNewTxt ? newTxt : txt.value),
            isChecked = (typeof isChecked && isChecked === true ? true : false),
            id = (typeof id && !isNaN(id) ? id : false);
        
        txtResult = txtInst.replace(/[^a-zøæå !()\d-_,.;:?]/ig, '');
        
        if (txtResult.replace(/\s/g, '').length > 0) {
            if (!id) {
                last_id++;
            }
            
            id = (id ? id : last_id + 1);

            var newRow = d.createElement('li');

            var newCheckbox = d.createElement('input');
            newCheckbox.setAttribute('type', 'checkbox');
            newCheckbox.checked = isChecked;
            newCheckbox.id = 'todo-box-' + id;
            newCheckbox.addEventListener('change', function () {
                
                for (i in lstArr) {
                    if (lstArr[i].id === parseInt(this.id.split('todo-box-')[1])) {
                        lstArr[i].checked = this.checked;
                    }
                }
                
                updateJsonCookie();
            });

            var newText = d.createElement('label');
            newText.setAttribute('for', 'todo-box-' + id);
            newText.innerHTML = txtResult; // Unngå hacks

            newRow.appendChild(newCheckbox);
            newRow.appendChild(newText);
            lst.appendChild(newRow);
            
            if (!isNewTxt) {
                lstArr.push({ text: txtResult, checked: isChecked, id: id });
            }
        }
        
        if (!isNewTxt) {
            txt.value = '';
            txt.focus();
        }
    }
    
    function updateJsonCookie () {
        var jsonObj = JSON.stringify(lstArr);
        //deleteCookie('list_data');
        setCookie('list_data', jsonObj);
    }
});

function getCookie(cookie) {
    
    // Vi grupperer cookie-verdien med parantes i en regex og passer på mellomrom med \s*
    // Cookies er også nå case sensitive fordi vi ikke inkluderer flagget i (i for in-case sensetive). Når uttrykket finner en match går den ut fordi vi ikke inkluderer flagget g (g for global, finner alle, men vi trenger bare den første).
    var reResult = new RegExp('(?:;|^)\s*' + cookie + '\s*=\s*([^;]+)\s*(?:;|$)').exec(document.cookie);
    
    return (reResult && reResult.length > 0 ? reResult[1] : false);
}

function setCookie(cookie, val, days) {
    days = (typeof days === 'undefined' ? 10*365 : days); // Default er 10 år
    var d = new Date();
    d.setTime(d.getTime() + (days*24*60*60*1000));
    var expires = 'expires=' + d.toUTCString();
    document.cookie = cookie + '=' + val + ';' + expires;
}

function deleteCookie(cookie) {
    document.cookie = cookie + '=;expires=Thu, 01 Jan 1970 00:00:00 UTC';
}