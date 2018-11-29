- **a) Hvor mange bits i datamaskinenes minne opptas ved bruk av dobbel-presisjons flyttallsformat?**

  - 64 bits

- **b) Hvordan er disse bitsene fordelt med tanke på antall bits til fortegn, eksponent og mantisse?**

  - 1 til fortegn
  - 11 til eksponent
  - 52 til mantisse

- **c) Hva er, i absoluttverdi, de største og minste tallene man kan representere ved bruk av dobbel-presisjons flyttall?**

  - Største tall: `0 11111111 xxxxxx...x => 1 * 2^128 * x = Infinite`.
  - Nest største tall: `0 11111110 11111111...1 => 1 * 2^1023 * 1.9999999... = 2^1024`.
  - Minste tall: `0 00000001 00000000...0 => 1 * 2^-1022 * 1.000 = 2^-1022`.

- **d) Konverter tallene under til dobbel-presisjons flyttall, fl(a), og kommentér for hver av dem om dette er en eksakt representasjon eller ikke. Du trenger ikke finne flere enn de åtte første mantissebitsene.**

  - 0.25: Eksakt. Eksponent: `125 => 2^125 = 01111101`. Mantisse: `0`.
  - 4.5: Eksakt. Eksponent: `129`. Mantisse: `2^-3 = 001`.
  - 0.1: Ikke eksakt fordi mantisse kan presiseres uendelig. Eksponent: `123`. Mantisse: `2^0 + 2^-3 + 2^-4 ... = 100110011 ...`.
  - Har verifisert svarene med koden i `./Theory.py`.

- **e) Finn den absolutte avrundingsfeilen til tallene under når dobbel-presisjons flyttall benyttes.**

  - 3.1415: `3.1415\*2^-52 = 6.975531263719859e-16`
  - 6.022140857\*10^23: `6.022140857\*10^23\*2^-52 = 133718388.73954543`
  - 0.8\*10^-10: `0.8\*10^-10\*2^-52 = 1.7763568394002506e-26`
  - Har verifisert svarene med koden i `./Theory.py`.
