package ensa.sri.indexationcv.representation;

import ensa.sri.indexationcv.entity.Attachment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CVShortRepresentation {
    String id;
    String username;
    Attachment attachment;
}
