package dev.netho.skywars.util;

import dev.netho.skywars.SkyWars;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

public class MusicPlayer {

    private final SkyWars plugin;

    public MusicPlayer(SkyWars plugin) {
        this.plugin = plugin;
    }

    public void playTWICE(Player player) {
        int[] noteTicks = new int[] {
                0,0,0,0,0,
                4,4,4,4,
                8,8,8,8,8,
                12,12,
                16,16,16,16,
                20,20,
                22,22,
                24,24,24,
                26,26,
                30,
                32,32,32,32,
                36,36,36,
                40,40,40,40,
                44,
                46,
                48,48,
                56,56,56,
                64,64,64,64,64,
                68,68,68,68,
                72,72,72,72,72,
                76,76,
                80,80,80,80,
                84,84,
                86,86,
                88,88,88,
                96,96,96,96,96,
                100,100,
                102,102,
                104,104,104,
                108,108,
                112,112,112,112,112,
                116,116,
                120,120,120,120,120

        }; // Time in ticks for each note
        Note[] notes = new Note[] {

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),
                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.B, false),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.D, false),
                new Note(0, Note.Tone.F, true),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.B, false),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.F, true),

                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),

                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.D, false),
                new Note(0, Note.Tone.F, true),

                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.B, false),

                new Note(0, Note.Tone.D, false),

                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.E, false),


                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.G, false),

                new Note(1, Note.Tone.F, true),

                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.B, false),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.G, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.A, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.A, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.A, false),

                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.A, false),

                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.E, false),

                new Note(0, Note.Tone.D, false),
                new Note(1, Note.Tone.D, false),
                new Note(0, Note.Tone.D, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.D, false),

                new Note(0, Note.Tone.D, false),
                new Note(0, Note.Tone.D, false),

                new Note(0, Note.Tone.E, false),
                new Note(1, Note.Tone.E, false),

                new Note(0, Note.Tone.D, false),
                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.A, false),

                new Note(1, Note.Tone.F, true),
                new Note(2, Note.Tone.F, true),

                new Note(1, Note.Tone.A, false),
                new Note(1, Note.Tone.A, false),
                new Note(0, Note.Tone.F, true),
                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.F, true),

                new Note(1, Note.Tone.B, false),
                new Note(1, Note.Tone.B, false),

                new Note(1, Note.Tone.D, false),
                new Note(1, Note.Tone.D, false),
                new Note(0, Note.Tone.A, false),
                new Note(0, Note.Tone.C, true),
                new Note(0, Note.Tone.F, true),
        };

        for (int i = 0; i < notes.length; i++) {
            int finalI = i;
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> player.playNote(player.getLocation(), Instrument.PIANO, notes[finalI]), noteTicks[i]);
        }
    }
}
