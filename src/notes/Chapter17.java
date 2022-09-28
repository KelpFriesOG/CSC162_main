package notes;

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
     */

    public static void main(String[] args) {

    }
}
