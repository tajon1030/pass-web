package com.fastcampus.passweb.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 왜 Integer로 들어가게되는거지? UserGroupMappingId가 아니라?
public interface UserGroupMappingRepository extends JpaRepository<UserGroupMapping, Integer> {

    @Query("""
            select distinct u.userGroupId
            from UserGroupMapping u
            order by u.userGroupId
            """)
    List<String> findDistinctUserGroupId();
}
