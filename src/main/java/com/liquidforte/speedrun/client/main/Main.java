package com.liquidforte.speedrun.client.main;

import com.google.common.base.Strings;
import com.liquidforte.speedrun.client.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Speedrun api = new SpeedrunClient().getApi();

        Writer out = new FileWriter("data.csv");
        CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL);

        printer.printRecord("Player", "Country", "Game", "Platform", "Category", "Date", "Submitted", "Verified", "Emulated", "Time", "Comment");

        for (int offset = 0; offset < 10; offset++) {
            List<Run> runs = api.getRuns(offset * 20).getData();
            for (Run run : runs) {
                if (!Strings.isNullOrEmpty(run.getPlayer()) && run.getDate() != null) {
                    User player = api.getUser(run.getPlayer()).getData();
                    Game game = api.getGame(run.getGame()).getData();
                    Category category = api.getCategory(run.getCategory()).getData();
                    printer.printRecord(player.getName(),
                            player.getCountry(),
                            game.getName(),
                            run.getPlatform(),
                            category.getName(),
                            run.getDate(),
                            run.getSubmitted(),
                            run.isVerified(),
                            run.isEmulated(),
                            run.getTimes().getPrimary_t(),
                            run.getComment());
                }
            }
        }


        printer.flush();
        out.flush();
        printer.close();
        out.close();
    }
}
