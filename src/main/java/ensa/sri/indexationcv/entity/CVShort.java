package ensa.sri.indexationcv.entity;

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
public class CVShort {
    @Id
    String id;
    String username;
    Attachment attachment;

}
