package hello.hellospring.repository

import hello.hellospring.domain.Member
import java.util.*

class MemoryMemberRepository : MemberRepository {
    val store = HashMap<Long, Member>()
    var sequence = 0L


    override fun save(member: Member): Member {

        member.id = ++sequence
        store.put(member.id ?: 0L, member)
        return member
    }

    override fun findById(id: Long): Optional<Member> {
        return Optional.ofNullable(store[id])
    }

    override fun findByName(name: String): Optional<Member> {
        return store.values.stream().filter {
            it.name?.equals(name) == true
        }.findAny()
    }

    override fun findAll(): List<Member> {
        return ArrayList(store.values)
    }
    fun clearStore(){
        store.clear()
    }
}