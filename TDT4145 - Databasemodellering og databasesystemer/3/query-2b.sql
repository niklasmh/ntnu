-- Slette kunde
DELETE FROM bestilling WHERE kunde_idkunde = {nr};
DELETE FROM kunde WHERE idkunde = {nr};

-- Slette artikkel
DELETE FROM artikkel WHERE artikkel_artnr = {nr};
DELETE FROM artikkel WHERE artnr = {nr};

-- De kan inkluderes i a) ved å spesifisere `ON DELETE {handling} ON UPDATE {handling (som CASCADE)}` etter nøkler.

-- Postnr burde være fremmednøkkel hos kunde slik at ikke personen er avhengig av dette nummeret.
