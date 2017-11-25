package ru.job4j.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class for sorting rows into a file.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 22.11.2017.
 */
public class FileRowSorter {
    /**
     * Start sorting.
     * @param source - file - source.
     * @param distance - file distance.
     */
    public void sort(File source, File distance) {
        long lineCount = 0;
        try (RandomAccessFile sourceFile = new RandomAccessFile(source, "r");
             RandomAccessFile distanceFile = new RandomAccessFile(distance, "rw")) {
            String line;

            while ((line = sourceFile.readLine()) != null) {
                if (lineCount != 0) {
                    distanceFile.write('\n');
                }
                distanceFile.write(line.getBytes());
                lineCount++;
            }
            distanceFile.close();
            distribute(distance);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Distribute data from one file-source to tow temp files.
     * source http://www.intuit.ru/studies/courses/648/504/lecture/11473?page=1#image.43.1 .
     * @param raf - file-source
     */
    public void distribute(File raf) {
        String tempFile1 = "..\\chapter_010\\src\\main\\java\\ru\\job4j\\io\\sources\\tmp1.txt";
        String tempFile2 = "..\\chapter_010\\src\\main\\java\\ru\\job4j\\io\\sources\\tmp2.txt";

        try (RandomAccessFile distanceFile = new RandomAccessFile(raf, "rw");
        RandomAccessFile tmp1 = new RandomAccessFile(tempFile1, "rw");
        RandomAccessFile tmp2 = new RandomAccessFile(tempFile2, "rw")) {
            boolean ready = false;
            long marker = 1;
            int phase = 1;
            long lineCount = getLineCount(distanceFile);
            while (!ready) {
                splitFile(distanceFile, tmp1, tmp2, marker);
                ready = mergeFiles(marker, lineCount, tmp1, tmp2, distanceFile);
                marker = (int) Math.pow(2, phase++);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        new File(tempFile1).delete();
        new File(tempFile2).delete();
    }

    /**
     * Create tow temp files and fill it from file-source.
     * @param source - file-source.
     * @param tmp1 - first temp file.
     * @param tmp2 - second temp file.
     * @param marker - count of compare operations.
     */
    private void splitFile(RandomAccessFile source, RandomAccessFile tmp1, RandomAccessFile tmp2, long marker) {
        long position = 0;
        RandomAccessFile dist = tmp1;

        clearFile(tmp1);
        clearFile(tmp2);

        try {
            tmp1.seek(0);
            tmp2.seek(0);
            source.seek(0);
            String line = source.readLine();

            while (line != null) {
                if (position == marker) {
                    dist = (dist == tmp1) ? tmp2 : tmp1;
                    position = 0;
                }
                dist.write(line.getBytes());
                position++;
                line = source.readLine();
                if (line != null) {
                    dist.write('\n');
                }
            }
            if (tmp2.length() != 0) {
                clearFile(source);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Compare strings from 2 files and push it into sortedCopy file.
     * @param marker - count of merge operation.
     * @param lineCount - count of lines at file source.
     * @param f1 - first temp file.
     * @param f2 - first temp file.
     * @param res - sortedCopy.
     * @return boolean.
     */
    private boolean mergeFiles(long marker, long lineCount, RandomAccessFile f1, RandomAccessFile f2, RandomAccessFile res) {
        boolean ready = false;
        long f1LineCount = 0;
        long f2LineCount = 0;
        long totalCount = 0;
        String f1Line = "";
        String f2Line = "";

        if (marker >= lineCount) {
            ready = true;
        } else {
            try {
                f1.seek(0);
                f2.seek(0);
                f1Line = f1.readLine();
                f2Line = f2.readLine();
                while (totalCount < lineCount) {
                    while (f1LineCount != marker || f2LineCount != marker) {
                        //Если строки в первом фале закончились
                        if (f1LineCount == marker || f1Line == null && f2Line != null) {
                            while (f2LineCount != marker) {
                                if (f2Line == null) {
                                    f2LineCount = marker;
                                    break;
                                }
                                res.write(f2Line.getBytes());
                                f2LineCount++;
                                f2Line = f2.readLine();
                                res.write('\n');
                            }
                            //Если строки во втором фале закончились
                        } else if (f2LineCount == marker || f2Line == null && f1Line != null) {
                            while (f1LineCount != marker) {
                                if (f1Line == null) {
                                    f1LineCount = marker;
                                    break;
                                }
                                res.write(f1Line.getBytes());
                                f1LineCount++;
                                f1Line = f1.readLine();
                                res.write('\n');
                            }
                        } else if (f1Line == null && f2Line == null) {
                            totalCount = marker;
                            //Если длинна строки в первом фале < чем во 2ом
                        } else if (f1Line.length() < f2Line.length()) {
                            res.write(f1Line.getBytes());
                            f1Line = f1.readLine();
                            f1LineCount++;
                            res.write('\n');
                        } else {
                            res.write(f2Line.getBytes());
                            f2Line = f2.readLine();
                            f2LineCount++;
                            res.write('\n');
                        }

                    }
                    totalCount += f1LineCount + f2LineCount;
                    f1LineCount = 0;
                    f2LineCount = 0;
                }

                clearFile(f1);
                clearFile(f2);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ready;
    }

    /**
     * Return count of lines at file.
     * @param file - source-file.
     * @return long.
     */
    private long getLineCount(RandomAccessFile file) {
        int count = 0;
        try {
            while (file.readLine() != null) {
                count++;
            }
            file.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Clear specified file.
     * @param file - file.
     */
    private void clearFile(RandomAccessFile file) {
        try {
            file.seek(0);
            file.setLength(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
