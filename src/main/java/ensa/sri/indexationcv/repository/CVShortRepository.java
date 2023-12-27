package ensa.sri.indexationcv.repository;


import ensa.sri.indexationcv.entity.CVShort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
@Component
public interface CVShortRepository extends ElasticsearchRepository<CVShort,String> {
}
