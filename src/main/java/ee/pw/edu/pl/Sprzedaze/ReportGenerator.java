package ee.pw.edu.pl.Sprzedaze;

import ee.pw.edu.pl.Sprzedaze.model.*;
import ee.pw.edu.pl.Sprzedaze.services.SprzedazService;
import org.docx4j.jaxb.Context;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;

public class ReportGenerator {

    public void GenerateDokumentSprzedazy(Sprzedaz sprzedaz, Platnosc platnosc, Nabywca nabywca,
                                          Sprzedawca sprzedawca, List<Usluga> uslugaList) throws Docx4JException {

        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", "Dokument sprzedazy");

        mainDocumentPart.addParagraphOfText("Dokument nr: " + sprzedaz.getNrRachunku());
        mainDocumentPart.addParagraphOfText("Data wystawienia: " + sprzedaz.getDataWystawienia().toString());

        mainDocumentPart.addStyledParagraphOfText("Subtitle", "Sprzedawca\n");
        mainDocumentPart.addParagraphOfText("Firma:" + sprzedawca.getNazwa());
        mainDocumentPart.addParagraphOfText(sprzedawca.getImieNazwisko());
        mainDocumentPart.addParagraphOfText(sprzedawca.getAdres());
        mainDocumentPart.addParagraphOfText(sprzedawca.getNip());
        mainDocumentPart.addParagraphOfText(sprzedawca.getEmail());
        mainDocumentPart.addParagraphOfText(sprzedawca.getNrTelefonu());
        mainDocumentPart.addParagraphOfText(sprzedawca.getNrKontaBank());

        mainDocumentPart.addStyledParagraphOfText("Subtitle", "Nabywca\n");
        mainDocumentPart.addParagraphOfText(nabywca.getNazwa());
        mainDocumentPart.addParagraphOfText(nabywca.getAdres());
        mainDocumentPart.addParagraphOfText(nabywca.getNip());

        mainDocumentPart.addStyledParagraphOfText("Subtitle", "Szczeg????y p??atno??ci\n");
        mainDocumentPart.addParagraphOfText("Suma: " + platnosc.getSumaPln().toString());
        mainDocumentPart.addParagraphOfText("S??ownie: " + platnosc.getKwotaSlownie());
        mainDocumentPart.addParagraphOfText("P??atne do: " + platnosc.getTerminPlatnosci().toString());
        if(platnosc.isFormaPlatnosci())
            mainDocumentPart.addParagraphOfText("Forma p??atno??ci: Got??wka");
        else
            mainDocumentPart.addParagraphOfText("Forma p??atno??ci: Przelew");
        mainDocumentPart.addParagraphOfText("Zap??acono: " + platnosc.getIleZaplacono().toString());
        mainDocumentPart.addParagraphOfText("Do zap??aty: " + (platnosc.getSumaPln().doubleValue() - platnosc.getIleZaplacono().doubleValue() ));

        mainDocumentPart.addStyledParagraphOfText("Subtitle", "Szczeg????y us??ug\n");
        for (Usluga usluga: uslugaList) {
            String p = "Nazwa us??ugi: " + usluga.getNazwa() + ",\njednostka miary: " + usluga.getJednostkaMiary() +
                    ",\ncena jednostkowa: " + usluga.getCenaJednostki() + ",\nilo???? jednostek: " + usluga.getIloscJednostek() +
                    ",\n????czna warto???? us??ugi: " + usluga.getWartosc();
            mainDocumentPart.addParagraphOfText(p);
        }

        File exportFile = new File("dokument.docx");
        wordPackage.save(exportFile);
    }

    public void GenerateRaport(List<Sprzedaz> listaSprzedazy) throws Docx4JException {

        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", "Podsumowanie sprzedazy");

        for (Sprzedaz sprzedaz: listaSprzedazy) {
            String p = "ID Sprzeda??y: " + sprzedaz.getIdSprzedazy() + ",\nNr rachunku: " + sprzedaz.getNrRachunku()
                    + ",\nNabywca: " + sprzedaz.getNabywca().getNazwa()
                    + ",\nData wystawienia: " + sprzedaz.getDataWystawienia() + ",\nSuma PLN: " + sprzedaz.getPlatnosc().getSumaPln();
            mainDocumentPart.addParagraphOfText(p);
        }

        File exportFile = new File("raport.docx");
        wordPackage.save(exportFile);
    }

}
