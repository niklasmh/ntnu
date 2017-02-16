-- a)
SELECT tittel
FROM bok;

-- b)
SELECT *
FROM forfatter;

-- c)
SELECT forlagnavn, telefon
FROM forlag
ORDER BY forlagnavn;

-- d)
SELECT tittel, forlagnavn
FROM forlag, bok
WHERE forlag.forlagid = bok.forlagid;

-- e)
SELECT tittel, utgittår
FROM forfatter AS f, bokforfatter AS bf, bok AS b
WHERE f.fornavn = 'Knut'
  AND f.etternavn = 'Hamsun'
  AND bf.forfatterid = f.forfatterid
  AND b.bokid = bf.bokid;

-- f)
SELECT fornavn, etternavn, fødeår
FROM forfatter
WHERE fornavn LIKE 'H%';

-- g)
SELECT COUNT(forlagid)
FROM forlag;

-- h)
SELECT b.tittel, f.fornavn, f.etternavn, fl.forlagnavn, f.nasjonalitet
FROM forfatter AS f, bok AS b, forlag AS fl, bokforfatter AS bf
WHERE f.nasjonalitet = 'Britisk'
  AND b.bokid = bf.bokid
  AND bf.forfatterid = f.forfatterid
  AND fl.forlagid = b.forlagid;

-- i)
SELECT f.fornavn, f.etternavn, COUNT(b.bokid) AS antall
FROM forfatter AS f, bokforfatter AS bf, bok AS b
WHERE f.forfatterid = bf.forfatterid
  AND bf.bokid = b.bokid
GROUP BY f.forfatterid;

-- j)
SELECT tittel, MIN(utgittår)
FROM bok;

-- k)
SELECT fl.forlagnavn, COUNT(b.bokid) AS antall
FROM forlag AS fl, bok AS b
WHERE b.forlagid = fl.forlagid
GROUP BY fl.forlagid
HAVING COUNT(*) > 1;

-- l)

SELECT forlagnavn
FROM forlag
WHERE forlagid NOT IN (
  SELECT fl.forlagid
  FROM forlag AS fl, bok AS b
  WHERE b.forlagid = fl.forlagid
);
