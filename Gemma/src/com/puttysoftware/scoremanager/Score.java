/*  LaserTank: An Arena-Solving Game
 Copyright (C) 2008-2010 Eric Ahnell

 Any questions should be directed to the author via email at: lasertank@worldwizard.net
 */
package com.puttysoftware.scoremanager;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;

import com.puttysoftware.xio.XDataReader;
import com.puttysoftware.xio.XDataWriter;

public final class Score {
    // Fields
    long[] scores;
    private String name;

    // Constructors
    public Score() {
        this.scores = new long[1];
        this.scores[0] = 0L;
        this.name = "Nobody";
    }

    public Score(long newScore, String newName) {
        this.scores = new long[1];
        this.scores[0] = newScore;
        this.name = newName;
    }

    public Score(int mv) {
        this.scores = new long[mv];
        for (int x = 0; x < mv; x++) {
            this.scores[x] = 0L;
        }
        this.name = "Nobody";
    }

    public Score(int mv, long[] newScore, String newName) {
        this.scores = new long[mv];
        for (int x = 0; x < mv; x++) {
            this.scores[x] = newScore[x];
        }
        this.name = newName;
    }

    // Methods
    public long getScore() {
        return this.scores[0];
    }

    public long getScore(int which) {
        return this.scores[which];
    }

    public String getName() {
        return this.name;
    }

    public void setScore(long newScore) {
        this.scores[0] = newScore;
    }

    public void setScore(int pos, long newScore) {
        this.scores[pos] = newScore;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public static Score readScore(XDataReader xdr) throws IOException {
        String sname = xdr.readString();
        int len = xdr.readInt();
        Score s = new Score(len);
        s.name = sname;
        for (int x = 0; x < len; x++) {
            s.scores[x] = xdr.readLong();
        }
        return s;
    }

    public void writeScore(XDataWriter xdw) throws IOException {
        xdw.writeString(this.name);
        xdw.writeInt(this.scores.length);
        for (int x = 0; x < this.scores.length; x++) {
            xdw.writeLong(this.scores[x]);
        }
    }

    public static class ScoreComparatorAsc
            implements Comparator<Score>, Serializable {
        private static final long serialVersionUID = 30523263423564L;

        @Override
        public int compare(Score o1, Score o2) {
            int lesser = Math.min(o1.scores.length, o2.scores.length);
            for (int z = 0; z < lesser; z++) {
                if (o1.scores[z] > o2.scores[z]) {
                    // Greater
                    return 1;
                } else if (o1.scores[z] < o2.scores[z]) {
                    // Lesser
                    return -1;
                } else {
                    // Equal
                    if (z == lesser - 1) {
                        // Run out of things to compare
                        return 0;
                    } else {
                        // Keep looping
                        continue;
                    }
                }
            }
            // Shouldn't ever get here
            return 0;
        }
    }

    public static class ScoreComparatorDesc
            implements Comparator<Score>, Serializable {
        private static final long serialVersionUID = 30523263423565L;

        @Override
        public int compare(Score o1, Score o2) {
            int lesser = Math.min(o1.scores.length, o2.scores.length);
            for (int z = 0; z < lesser; z++) {
                if (o1.scores[z] > o2.scores[z]) {
                    // Greater
                    return -1;
                } else if (o1.scores[z] < o2.scores[z]) {
                    // Lesser
                    return 1;
                } else {
                    // Equal
                    if (z == lesser - 1) {
                        // Run out of things to compare
                        return 0;
                    } else {
                        // Keep looping
                        continue;
                    }
                }
            }
            // Shouldn't ever get here
            return 0;
        }
    }
}
