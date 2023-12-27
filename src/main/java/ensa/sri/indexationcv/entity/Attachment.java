package ensa.sri.indexationcv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attachment {
    public String content_type;
    public String author;
    public String title;
    public String language;
    public String content;
}
