- **a) Hvor mange bits i datamaskinenes minne opptas ved bruk av dobbel-presisjons flyttallsformat?**

  - 64 bits

- **b) Hvordan er disse bitsene fordelt med tanke på antall bits til fortegn, eksponent og mantisse?**

  - 1 til fortegn
  - 11 til eksponent
  - 52 til mantisse

- **c) Hva er, i absoluttverdi, de største og minste tallene man kan representere ved bruk av dobbel-presisjons flyttall?**

  - Største tall: `1 11111111 xxxxxx...x => 1 * 2^128 * x = Infinite`.
  - Nest største tall: `1 11111110 11111111...1 => 1 * 2^127 * 0.9999999... = 2^128`.
  - Minste tall: `1 00000000 00000000...0 => 1 * 2^0 * 0 = 0`.

- **d) Konverter tallene under til dobbel-presisjons flyttall, fl(a), og kommentér for hver av dem om dette er en eksakt representasjon eller ikke. Du trenger ikke finne flere enn de åtte første mantissebitsene.**

  - 0.25: Eksakt. Eksponent: `125`. Mantisse: `2^-1 = .01`.
  - 4.5: Eksakt. Eksponent: `129`. Mantisse: `2^0 = .1`.
  - 0.1: Ikke eksakt fordi mantisse kan presiseres uendelig. Eksponent: `123`. Mantisse: `2^0 + 2^-2 + 2^-3 ... = .100110011 ...`.
  - Har verifisert svarene med koden i `./Theory.py`.

- **e) Finn den absolutte avrundingsfeilen til tallene under når dobbel-presisjons flyttall benyttes.**

  - 3.1415: -3.814697265625e-9
  - 6.022140857\*10^23: 14683781913362432
  - 0.8\*10^-10: -3.196642239799984963610768318e-19
