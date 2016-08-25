var d = document, i, table;

d.addEventListener('DOMContentLoaded', function () {
    table = d.getElementById('the-table-body');
    
    var btnCol1 = d.getElementById('sort-button-1'),
        btnCol2 = d.getElementById('sort-button-2'),
        btnCol3 = d.getElementById('sort-button-3');
    
    btnCol1.addEventListener('click', function () {
        sortTableByCol(table, 1);
    });
    
    btnCol2.addEventListener('click', function () {
        sortTableByCol(table, 2);
    });
    
    btnCol3.addEventListener('click', function () {
        sortTableByCol(table, 3);
    });
});

// Lager en funksjon som kan ta inn tabell, colonne og hvilken vei radene skal sorteres etter
function sortTableByCol(table, col, desc) {
    
    if (table && typeof table !== 'undefined') { // Sjekke om table er fylt inn, ellers returnerer den false
        col = (col && typeof col !== 'undefined' && !isNaN(col) && col > 0 ? col : 1); // Første kolonne er default
        desc = (desc && typeof desc !== 'undefined' && desc === true ? true : false); // Sorterer stigende som default, alså ascending
        
        var lstNew = [],
            anyChange = true,
            rows = table.querySelectorAll('tr'); // Lager piler til radene. Siden de blir piler til objektet kan vi modifisere rows samtidig som vi endrer table-objektet
        
        for (i = 0; i < rows.length; i++) {
            lstNew.push(rows[i].children[col-1].innerHTML);
        }
        
        while (anyChange) {
            var start = (desc ? 1 : 0),
                step = (desc ? -1 : 1);
            
            anyChange = false;
            
            for (i = start; i < lstNew.length + start - 1; i++) {
                
                // Får tak i verdiene og klassifiserer de enten som tall hvis tall, ellers ASCII-verdier
                var val = (isNaN(lstNew[i]) ? lstNew[i].charCodeAt(0) : lstNew[i]);
                var val2 = (isNaN(lstNew[i+step]) ? lstNew[i+step].charCodeAt(0) : lstNew[i+step]);
                
                // Bruker bubble-sort-metoden siden den er enkel å ta i bruk, men ikke optimal. I denne oppgaven vil den maks bruke 5 steg, så det er greit for nå
                
                if (val > val2) {
                    var saveFirst = { lst: lstNew[i], dom: [] };
                    
                    for (var j = 0; j < rows[i].children.length; j++) {
                        saveFirst.dom.push(rows[i].children[j].innerHTML);
                    }
                    
                    lstNew[i] = lstNew[i+step];
                    lstNew[i+step] = saveFirst.lst;
                    
                    for (var j = 0; j < rows[i].children.length; j++) {
                        rows[i].children[j].innerHTML = rows[i+step].children[j].innerHTML;
                        rows[i+step].children[j].innerHTML = saveFirst.dom[j];
                    }
                    
                    anyChange = true;
                }
            }
        }
        
        return table;
    }
    
    return false;
}