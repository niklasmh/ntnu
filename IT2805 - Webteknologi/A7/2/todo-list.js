var d = document, lstArr, last_id = 0;

d.addEventListener('DOMContentLoaded', function () {
    var lst = d.getElementById('todo-lst'),
        btnClear = d.getElementById('clear-btn'),
        btnAdd = d.getElementById('add-btn'),
        txt = d.getElementById('todo-txt'),
        items = lst.querySelectorAll('li'),
        lstArr = [];
    
    // Henter ferdig innlagte instanser i listen og maks id
    for (var i = 0; i < items.length; i++) {
        lstArr.push(items[i].children[1].innerHTML);
        last_id = Math.max(last_id, items[i].children[1].getAttribute('for').split('todo-box-')[1]);
    }
    
    // Så vi kan legge til med enter-tasten
    txt.addEventListener('keydown', function (e) {
        if (e.keyCode == 13 && txt.value.length > 0) {
            addElementFromInput();
        }
    });
    
    // Så vi kan legge til med +-knappen
    btnAdd.addEventListener('click', function () {
        addElementFromInput();
    });
    
    // Så vi kan fjerne de merkede
    btnClear.addEventListener('click', function () {
        var newRow = lst.querySelectorAll('li');
        
        for (var i = 0; i < newRow.length; i++) {
            if (newRow[i].children[0].checked) {
                lst.removeChild(newRow[i]);
            }
        }
    });
    
    function addElementFromInput () {
        txtResult = txt.value.replace(/[^a-zøæå !()\d-_,.;:?]/ig, '');
        
        if (txtResult.length > 0) {
            last_id++;

            var newRow = d.createElement('li');

            var newCheckbox = d.createElement('input');
            newCheckbox.setAttribute('type', 'checkbox');
            newCheckbox.id = 'todo-box-' + (last_id + 1);

            var newText = d.createElement('label');
            newText.setAttribute('for', 'todo-box-' + (last_id + 1));
            newText.innerHTML = txtResult; // Unngå hacks

            newRow.appendChild(newCheckbox);
            newRow.appendChild(newText);
            lst.appendChild(newRow);
        }

        txt.value = '';
        txt.focus();
    }
});