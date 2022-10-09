package notes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Chapter17 {
    /*
     * Chapter 17: Binary I/O
     * 
     * Main Goals:
     * - Discover how I/O is processed in Java
     * - Distinguish between text I/O and binary
     * - To read and write bytes using FileInputStream and
     * FileOutputStream
     * - To filter data using the base classes FilterInputStream
     * and FilterOutputStream
     * - To read and write primitive values and strings using
     * DataInputStream and DataOutputStream
     * - To improve I/O performance by using BufferedInputStream
     * and BufferedOutputStream
     * - To write a program that copies a file.
     * - To store and restore objects using ObjectOutputStream
     * and ObjectInputStream
     * - To implement the Serializable interface
     * - To serialize arrays
     * - Read and write files using the RandomAccessFile class
     * 
     * How is Text I/O Handled?-------------------------------------------------
     * 
     * The PrintWriter class writes a string to a file, whereas the
     * Scanner class reads a string from a file or user input.
     * 
     * PrintWriter can be classified as an output class because it contains
     * methods to write data, whereas the Scanner class is an input class
     * because it contains methods to read data.
     * 
     * Scanner => reads a stream of data from a file => input class
     * PrintWriter => writes a stream of data to a file => output class
     * 
     * An input class creates an input object which is also referred to as
     * an input stream. An output class creates an output object which
     * is referred to as an output stream.
     * 
     * You can think of Streams as data "roads" or "wires" which contains
     * a bunch of bytes (binary) being sent from or to a file.
     * 
     * Text I/O vs Binary I/O---------------------------------------------------
     * 
     * COMPUTERS DO NOT DIFFERENTIATE BETWEEN BINARY AND TEXT FILES.
     * ALL FILES ARE ESSENTIALLY BINARY FILES.
     * 
     * When we conduct text I/O, when we send data into a file, it needs
     * to be encoded to be stored as binary. When we retrieve data from
     * a file, it needs to be decoded back into a String value.
     * 
     * If we instead use binary I/O, we can read and write bytes directly
     * into the file instead of working with Unicode. Therefore,
     * BINARY I/O DOES NOT REQUIRE ENCODING AND DECODING.
     * 
     * Why use binary I/O:
     * Since binary does not require additional encoding / decoding,
     * it is independent of any encoding scheme present on any machine,
     * it is a portable, versatile, hardware and software independent file.
     * 
     * Java programs on any machine can read a binary file created by a Java
     * program, this is why Java's .class files are in binary, they can
     * run on a JVM on any machine.
     * 
     * Binary I/O Classes-------------------------------------------------------
     * 
     * NOTE: InputStream and OutputStream are ABSTRACT classes,
     * they serve as contracts for subclasses but are not constructable!
     * 
     * |======================== java.io.InputStream ==========================|
     * 
     * +read(): int
     * Reads the next byte of data from the input stream. The value byte is
     * returned as an int value in the range 0–255. If no byte is available
     * because the end of the stream has been reached, the value –1 is returned.
     * 
     * +read(b: byte[]): int
     * Reads up to b.length bytes into array b from the input stream and
     * returns the actual number of bytes read. Returns –1 at the end of
     * the stream.
     * 
     * +read(b: byte[], off: int, len: int): int
     * Reads bytes from the input stream and stores them in b[off], b[off+1],
     * ..., b[of f+len–1]. The actual number of bytes read is returned.
     * Returns –1 at the end of the stream.
     * 
     * +close(): void
     * Closes this input stream and releases any system resources occupied.
     * 
     * +skip(n: long): long
     * Skips over and discards n bytes of data from this input stream.
     * The actual number of bytes skipped is returned.
     * 
     * |=======================================================================|
     * 
     * |========================= java.io.OutputStream ========================|
     * 
     * +write(int b): void
     * Writes the specified byte to this output stream. The parameter b is
     * an int value. The casted (byte) b is written to the output stream.
     * 
     * +write(b: byte[]): void
     * Writes all the bytes in array b to the output stream.
     * 
     * +write(b: byte[], off: int, len: int): void
     * Writes b[of f], b[off+1],..., b[of f+len–1] into the output stream.
     * 
     * +close(): void
     * Closes this output stream and releases any system resources.
     * 
     * +flush(): void
     * Flushes this output stream and forces any buffered output bytes
     * to be written out.
     * 
     * |=======================================================================|
     * 
     * |======================= java.io.FileInputStream =======================|
     * IMPLEMENTS java.io.InputStream
     * 
     * +FileInputStream(file: File)
     * Creates a FileInputStream from a File object.
     * 
     * +FileInputStream(filename: String)
     * Creates a FileInputStream from a file name (path).
     * 
     * |=======================================================================|
     * 
     * |======================= java.io.FileOutputStream ======================|
     * IMPLEMENTS java.io.OutputStream
     * 
     * +FileOutputStream(file: File)
     * Creates a FileOutputStream from a File object.
     * 
     * +FileOutputStream(filename: String)
     * Creates a FileOutputStream from a file name
     * 
     * +FileOutputStream(file: File, append: boolean)
     * If append is true, data are appended to the existing file.
     * 
     * +FileOutputStream(filename: String, append: boolean)
     * If append is true, data are appended to the existing file.
     * 
     * |=======================================================================|
     * 
     * Almost all methods in the I/O category throw a java.io.IOException.
     * As a result you need to be able to throw the IO Exception from the
     * method or via a try catch block!
     * 
     * -------------------------------------------------------------------------
     * 
     * |======================= java.io.DataInputStream =======================|
     * extends FilterInputStream (which itself extends InputStream)
     * and implements DataInput
     * 
     * +DataInputStream(in: InputStream)
     * 
     * readBoolean(): boolean
     * Reads a boolean from the input stream
     * 
     * readByte(): byte
     * Reads a byte from the input stream
     * 
     * readChar(): char
     * Reads a character from the input stream
     * remember that one unicode character is 2 bytes
     * 
     * readFloat(): float
     * Reads a float from the input stream
     * 
     * readDouble(): double
     * Reads a double from the input stream
     * 
     * readInt(): int
     * Reads a int from the input stream
     * 
     * readLong(): long
     * Reads a long from the input stream
     * 
     * readShort(): short
     * Reads a short from the input stream
     * 
     * readLine(): String
     * Reads a line of characters from the input stream
     * 
     * readUTF(): String
     * Reads a String in UTF format from the input stream
     * 
     * |=======================================================================|
     * 
     * |====================== java.io.DataOutputStream =======================|
     * extends FilterOutputStream (which itself extends OutputStream)
     * and implements DataOutput
     * 
     * +DataOutputStream(out: OutputStream)
     * 
     * writeBoolean(b: boolean) : void
     * writeByte(v: int): void
     * writeBytes(s: String): void
     * writeChar(c: char): void
     * writeChars(s: String): void
     * writeFloat(v: float): void
     * writeDouble(v: double): void
     * writeInt(v: int): void
     * writeLong(v: long): void
     * writeShort(v: short): void
     * writeUTF(String s): void
     * 
     * |=======================================================================|
     * 
     * Filter streams are streams that filter bytes for some purpose.
     * The basic byte input stream provides a read method that can be used only
     * for reading bytes.
     * 
     * If you want to read integers, doubles, or strings, you need a filter
     * class to wrap the byte input stream. Using a filter class
     * enables you to read integers, doubles, and strings instead of bytes and
     * characters. FilterInputStream and FilterOutputStream are the
     * base classes for filtering data.
     * 
     * DataInputStream and DataOutputStream read and write Java primitive-type
     * values and strings in a machine-independent fashion, thereby enabling
     * you to write a data file on one machine and read it on another machine
     * that has a different operating system or file structure.
     * An application uses a data output stream to write data that can later
     * be read by a program using a data input stream.
     * 
     * -------------------------------------------------------------------------
     * 
     * If you keep reading data at the end of an InputStream, an EOFException
     * will occur. This exception can be used to detect the end of a file
     * and stop reading the file when it occurs.
     * 
     * -------------------------------------------------------------------------
     * 
     * |===================== java.io.BufferedInputStream =====================|
     * extends FilterInputStream (which itself extends InputStream)
     * 
     * +BufferedInputStream(in: InputStream)
     * +BufferedInputStream(in: InputStream, bufferSize: int)
     * 
     * |=======================================================================|
     * 
     * |==================== java.io.BufferedOutputStream ====================|
     * extends FilterOutputStream (which itself extends OutputStream)
     * 
     * +BufferedOutputStream(out: OutputStream)
     * +BufferedOutputStream(out: OutputStream, bufferSize: int)
     * 
     * |=======================================================================|
     * 
     * BufferedInputStream and BufferedOutputStream classes can be used to
     * SPEED UP input and output operation time by reducing the number /
     * frequency of disk reads and writes.
     * 
     * For BufferedInputStream
     * The whole block of data can be read from your disk and placed into the
     * buffer in RAM once. Then the individual data are loaded to your program
     * from the buffer (rather than travelling from the disk).
     * 
     * For BufferedOutputStream
     * The individual data is first written to the buffer, when the buffer is
     * full, all data from the buffer is written to the disk as one chunk.
     * 
     * In other words the buffer limits the frequency of disk read/write
     * calls to write and read data quickly (avoiding the delay of multiple
     * pings to the data disk).
     * 
     * The default size of thee buffer in both cases is 512 bytes
     * but the size can be set in the constructor as well!
     * 
     * -------------------------------------------------------------------------
     * 
     * If DataInputStream/DataOutputStream allows you to perform I/O for
     * primitives and Strings, then ObjectInputStream/ObjectOutputStream enables
     * I/O for objects in addition to primitives and Strings.
     * 
     * |====================== java.io.ObjectOutputStream =====================|
     * implements java.io.ObjectOutput interface (which in itself extends the
     * DataOutput interface) and the ObjectStreamConstants interface
     * and extends the OutputStream class
     * 
     * +ObjectOutputStream(out: OutputStream)
     * 
     * writeObject(o: Object): void
     * 
     * |=======================================================================|
     * 
     * |====================== java.io.ObjectInputStream ======================|
     * implements java.io.ObjectInput interface (which in itself extends the
     * DataInput interface) and the ObjectStreamConstants interface
     * and extends the InputStream class.
     * 
     * +ObjectInputStream(in: InputStream)
     * 
     * readObject(): Object
     * 
     * |=======================================================================|
     * 
     * 
     * -------------------------------------------------------------------------
     * 
     */

    static void testFileStream() {
        // Creating an output stream to the file (makes the file if not present.)
        try (FileOutputStream output = new FileOutputStream("temp.dat")) {
            for (int i = 1; i <= 10; i++) {
                // Writes (outputs) values to file
                output.write(i);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        // Creating an input stream to the file
        try (FileInputStream input = new FileInputStream("temp.dat")) {
            int value;
            // Reads (inputs) values from file
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        // When a stream is no longer needed, always close it using the close() method
        // or
        // automatically close it using a try-with-resource statement. Not closing
        // streams may
        // cause data corruption in the output file or other programming errors.

    }

    static void testDataStream() {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Susan");
            output.writeDouble(185.5);
            output.writeUTF("Kim");
            output.writeDouble(105.25);
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        try (DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    static void detectEndOfFile() {
        try {
            try (DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"))) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }

            try (DataInputStream input = new DataInputStream(new FileInputStream("test.dat"))) {
                while (true)
                    System.out.println(input.readDouble());
            }

        } catch (EOFException e) {
            System.out.println("All data was read!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testObjectOutputStream() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"))) {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    static void testObjectInputStream() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"))) {
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) (input.readObject());
            System.out.println(name + " " + score + " " + date);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        // testFileStream();
        testDataStream();
    }
}
