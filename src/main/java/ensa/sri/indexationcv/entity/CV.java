package ensa.sri.indexationcv.entity;

import ensa.sri.indexationcv.representation.CVLongRepresentation;
import ensa.sri.indexationcv.representation.CVShortRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "cv")
public class CV {
    @Id
    String id;
    String username;
    String data;
    Attachment attachment;

    public CVShortRepresentation toCVShortRepresentation(){
        return CVShortRepresentation.builder()
                .id(id)
                .username(username)
                .attachment(attachment)
                .build();
    }

    public CVLongRepresentation toCVLongRepresentation(){
        return CVLongRepresentation.builder()
                .id(id)
                .username(username)
                .data(data)
                .attachment(attachment)
                .build();
    }

}