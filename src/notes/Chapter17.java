package notes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

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
     * -------------------------------------------------------------------------
     * 
     * Not every object can be written to an output stream, objects that can
     * be written are known as SERIALIZABLE objects. A serializable object is
     * an instance of java.io.Serializable interface, therefore it must
     * implement the Serializable interface.
     * 
     * The Serializable interface is a marker interface and does not have any
     * requirements for the implementer to fulfill. The interface
     * automatically allows Java's serialization mechanism to take over
     * and automate the process of storing objects and arrays.
     * 
     * Object serialization: automating the proccess of writing objects to files
     * Object deserialization: automating the process of reading objects from files.
     * 
     * All the wrapper classes for primitive-type values: java.math.BigInteger,
     * java.math.BigDecimal, java.lang.String, java.lang.StringBuilder,
     * java.lang.StringBuffer, java.util.Date, and java.util.ArrayList implement
     * java.io.Serializable.
     * 
     * Attempting to store an object that does not support the Serializable
     * interface would cause a NotSerializableException.
     * 
     * When an serializable object is stored, the class of the object is encoded,
     * this includes the name and signature of the class, the values of the
     * object's instance variables, and the closure of any other objects
     * referenced by the object. The object's STATIC and TRANSIENT VARIABLES ARE
     * NOT STORED.
     * 
     * Remember that ARRAYS ARE SERIALIZABLE but casting is required to
     * pickup the arrays as their appropriate types.
     * 
     * -------------------------------------------------------------------------
     * 
     * |====================== java.io.RandomAccessFile =======================|
     * implements both the Java.io.DataInput and java.io.DataOutput interfaces.
     * 
     * +RandomAccessFile(file: File, mode: String)
     * Creates a RandomAccessFile stream with the specified File object and
     * mode.
     * 
     * +RandomAccessFile(name: String, mode: String)
     * Creates a RandomAccessFile stream with the specified file name
     * string and mode.
     * 
     * close(): void
     * Closes the stream and releases the resources associated with it.
     * 
     * getFilePointer(): long
     * Returns the offset, in bytes, from the beginning of the file to where
     * the next read or write occurs. (our location in the file)
     * 
     * length(): long
     * Returns the length of the file
     * 
     * read(): int
     * Reads a byte of data from this file and
     * returns -1 at the end of the stream.
     * 
     * read(b: byte[]): int
     * Reads up to b.length bytes of data from this
     * file into an array of bytes. (Moves the read data into the byte
     * array to fill it up as much as possible).
     * 
     * read(b: byte[], offset: int, len: int): int
     * Reads upto len bytes of data from this file beginning at the offset
     * into the array of bytes.
     * 
     * seek(pos: long): void
     * Sets the offset (in bytes specified by pos) from the beginning of the
     * stream to where the next read or write will occur.
     * 
     * setLength(newLength: long): void
     * Sets a new length for the file
     * 
     * skipBytes(int n): int
     * Skips over n bytes.
     * 
     * write(b: byte[]): void
     * Writes b.length bytes from the specified byte array into this file
     * starting at the current location of the file pointer.
     * 
     * write(b: byte[], offset: int, len: int): void
     * Writes len bytes from the byte array (starting at the offset)
     * to this file.
     * 
     * |=======================================================================|
     * 
     * A random-access file consists of a sequence of bytes. A special marker
     * called a file pointer is positioned at one of these bytes. A read or
     * write operation takes place at the location of the file pointer.
     * When a file is opened, the file pointer is set at the beginning of
     * the file. When you read from or write data to the file, the file pointer
     * moves forward to the next data item.
     * 
     * -------------------------------------------------------------------------
     * 
     */

    // #region Textbook Examples

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
            output.writeUTF("John");
            output.writeDouble(89);
            output.writeObject(new java.util.Date());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    static void testObjectInputStream() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"))) {
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) (input.readObject());
            System.out.println(name + " " + score + " " + date);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    static void testObjectStreamForArray() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        String[] names = { "John", "Kelp", "Kimmie" };

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("array.dat", true))) {

            output.writeObject(numbers);
            output.writeObject(names);

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("array.dat"))) {

            int[] newNumbers = (int[]) (input.readObject());
            String[] newStrings = (String[]) (input.readObject());

            // Displaying the arrays
            for (int i = 0; i < newNumbers.length; i++) {
                System.out.println(newNumbers[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < newStrings.length; i++) {
                System.out.println(newStrings[i] + ", ");
            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

    }

    static void testRandomAccessFile() {
        try (RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw")) {

            inout.setLength(0);
            // resets the contents
            for (int i = 0; i < 200; i++) {
                inout.writeInt(i);
            }
            // Fills the file with numbers from 0 to 200
            // This will move the file pointer along with it, so we
            // need to account for that later.

            System.out.println("The current file length is " + inout.length());

            inout.seek(0); // Resets position of file pointer
            System.out.println("The first number is " + inout.readInt());

            inout.seek(1 * 4);
            System.out.println("The second number is " + inout.readInt());

            System.out.println("The third number is " + inout.readInt());
            // The inout's file pointer automatically increments the 4 bytes needed

            inout.writeInt(777);
            // The fourth number is modified to 777

            inout.seek(inout.length()); // Moves the file pointer to the end
            inout.writeInt(999); // Appends this new number to the file

            System.out.println("The new file length is " + inout.length());
            // Should be 4 more bytes to accomodate for the new int

            inout.seek(4 * 3);
            System.out.println("The 4th number is " + inout.readInt());

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    // #endregion

    public static void main(String[] args) {
        // testFileStream();
        // testDataStream();
        // detectEndOfFile();
        // testObjectOutputStream();
        // testObjectInputStream();
        // testObjectStreamForArray();
        // testRandomAccessFile();

    }
}
