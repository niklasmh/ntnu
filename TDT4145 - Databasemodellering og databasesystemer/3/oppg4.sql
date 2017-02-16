-- a) Abstraksjon, sikkerhet.

-- Problemer med oppdateringer på basistabeller kan skje gjennom views pga. flere tabeller har spesielle rekkefølger osv. Er mulig, da.

-- b)

CREATE VIEW prosjekt2 (p_name, d_name, no_e, tot_hours) AS SELECT PNAME, DNAME, COUNT(*), SUM(HOURS)
FROM PROJECT, DEPARTMENT, WORKS_ON
WHERE DNUM = DNUMBER
  AND PNUMBER = PNO
GROUP BY PNAME

-- c1)

SELECT DNO, COUNT(*), SUM(SALARY), AVG(SALARY)
FROM EMPLOYEE
GROUP BY DNO;

-- c2)

SELECT DNO, COUNT(*)
FROM EMPLOYEE
GROUP BY DNO
HAVING SUM(SALARY) > 10000;

-- c3)

Det kan ikke oppdateres pga. aggragater. Det er en litt fake tabell, så burde i grunn ikke belage seg på å kunne gjøre slikt med et view.

-- c4)

Det må mer til for å slette. Isåfall burde det fikses med en nøkkelhandling når den slettes.
