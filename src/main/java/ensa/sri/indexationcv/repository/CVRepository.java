package ensa.sri.indexationcv.repository;


import ensa.sri.indexationcv.entity.CV;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CVRepository extends ElasticsearchRepository<CV,String> {
    boolean existsById(String id);
}
