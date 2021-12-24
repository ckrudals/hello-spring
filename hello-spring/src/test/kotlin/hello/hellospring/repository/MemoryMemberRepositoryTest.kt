package hello.hellospring.repository

import hello.hellospring.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.util.Assert

class MemoryMemberRepositoryTest {
    val repository = MemoryMemberRepository()

    // 테스트는 순서와 관계없이 설계해야함

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member = Member(name = "spring", id = 0)

        repository.save(member)
        val result = repository.findById(member.id!!).get()
        // 둘이 값 같은지 비교
        Assertions.assertEquals(member, result)
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result)
    }

    @Test
    fun findByName() {
        val member1 = Member(0, "spring")
        repository.save(member1)
        val member2 = Member(0, "spring2")
        repository.save(member2)

        val result = repository.findByName("spring2").get()

        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1)

    }

    @Test
    fun findAll() {
        val member1 = Member(0, "spring")
        repository.save(member1)
        val member2 = Member(0, "spring2")
        repository.save(member2)
        val result = repository.findAll()
        org.assertj.core.api.Assertions.assertThat(result.size).isEqualTo(2)


    }
}