package com.api.socialMaker.repositories;

import com.api.socialMaker.models.UserSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSearchRepository extends ElasticsearchRepository<UserSearch, String> {
    List<UserSearch> findByUserNameContainingOrFullNameContaining(String username);
}
