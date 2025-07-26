package org.echonanguo.lemall.portal.repository;

import org.echonanguo.lemall.portal.domain.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 会员关注Repository
 * Created by echonanguo on 2025/4/21.
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention,String> {
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);
    int deleteByMemberIdAndBrandId(Long memberId,Long brandId);
    Page<MemberBrandAttention> findByMemberId(Long memberId, Pageable pageable);
    void deleteAllByMemberId(Long memberId);
}
