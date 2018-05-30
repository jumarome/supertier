package com.gt.supertier.business.user.entitiy;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface UserRepository extends EntityRepository<User,Integer> {
    User findOptionalByUsername(String username);
}
