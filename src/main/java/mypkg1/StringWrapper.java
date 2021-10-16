package mypkg1;

import lombok.*;
import lombok.libs.com.zwitserloot.cmdreader.Requires;

@Getter
@Setter
//@ToString
public class StringWrapper {
    private String string;

    public StringWrapper(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
