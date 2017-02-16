-- a)

SELECT *
FROM Supplier
WHERE status > 15;

-- b)

SELECT sname, s.city
FROM Supplier s, SuppliesPart AS sp, Part AS p
WHERE s.sno = sp.sno
  AND sp.pno = p.pno
  AND p.pname = 'Screw';

-- c)

SELECT pno, pname
FROM Part
WHERE pno IN (
  SELECT pno
  FROM SuppliesPart
  GROUP BY pno
  HAVING COUNT(*) > 1
);

-- d)

SELECT COUNT(*)
FROM Supplier;

-- e)

SELECT s.city
FROM Supplier AS s, Part AS p, SuppliesPart AS sp
WHERE s.sno = sp.sno
  AND sp.pno = p.pno
  AND p.weight > 10;

-- f)

SELECT DISTINCT sname
WHERE sno NOT IN (
  SELECT sp.sno
  FROM SuppliesPart AS sp, Part AS p
  WHERE sp.pno = p.pno AND p.pname = 'Screw'
)
ORDER BY sname;
