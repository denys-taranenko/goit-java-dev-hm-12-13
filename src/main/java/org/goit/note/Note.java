package org.goit.note;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;
}
