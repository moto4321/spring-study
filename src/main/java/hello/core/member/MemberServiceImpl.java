package hello.core.member;

public class MemberServiceImpl implements MemberService {


//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 실제론 구현체를 의존하는 형태이네?
    // 결국 MemberService는 MemberRepository에도 의존하고 MemoryMemberRepository에도 의존하네?
    // 추상화에도 의존하고 구체화에도 의존하네? 결국 DIP를 위반하고 있는 상태이다.
    // 근데 여기세 final을 넣네??

    private final MemberRepository memberRepository; // interface만 존재

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
