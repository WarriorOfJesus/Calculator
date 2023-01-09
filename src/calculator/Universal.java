package calculator;

import java.io.IOException;

public interface Universal extends Divisionable, Multiplicationable, Additionable, Substractionable, Printable, Readable, Percentable, Writable {
    void universal() throws IOException;
}
