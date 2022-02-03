
INSERT INTO `mydb`.`knjiga` (`id`, `naziv`, `isbn`, `izdavackaKuca`, `autor`, `godinaIzdavanja`, `opis`, `slika`, `cena`, `brojStranica`, `tipPoveza`, `pismo`, `jezik`, `prosecnaOcena`) 
VALUES ('1', 'Biti covek', '123', 'Zavod', 'Marti', '2021-01-01', 'Biti čovek preispituje najnovija naučna otkrića pružajući jedinstven uvid u neobične aspekte ljudskog ponašanja', 'nema', '700', '200', 'TVRDI', 'LATINICA', 'srpski', '4');


INSERT INTO `mydb`.`knjiga` (`id`, `naziv`, `isbn`, `izdavackaKuca`, `autor`, `godinaIzdavanja`, `opis`, `slika`, `cena`, `brojStranica`, `tipPoveza`, `pismo`, `jezik`, `prosecnaOcena`) 
VALUES ('2', 'Zlocin i kazna', '1234', 'Vulkan', 'Dostojevski', '2019-01-02', 'Ovo je kriminalni roman, jer govori o junaku ubici i o traganju policije za njim.', 'nema', '900', '714', 'TVRDI', 'LATINICA', 'srpski', '5');


INSERT INTO `mydb`.`korisnik` (`id`, `korisnickoIme`, `lozinka`, `email`, `ime`, `prezime`, `datumRodjenja`, `adresa`, `brojTelefona`, `datumVremeRegistracije`, `uloga`) 
VALUES ('1', 'admin', 'admin', 'admin@gmail.com', 'admin', 'admin', '1990-01-05', 'ns', '123456', '2021-01-01', 'ADMINISTRATOR');