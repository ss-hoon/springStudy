package com.example.springstudy.repository;

import com.example.springstudy.SpringstudyApplicationTests;
import com.example.springstudy.model.entity.User;
import com.example.springstudy.model.enumClass.UserStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends SpringstudyApplicationTests {

    //디자인 패턴
    // 의존성의 주입 : 자동으로 @Autowired를 찾아 의존성을 주입해준다. 객체를 생성할 필요 없다.
    // Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void create(){
        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test03@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
//        user.setCreatedAt(createdAt);
//        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        if(user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("=============== 주문 묶음 ===============");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총 금액 : " + orderGroup.getTotalPrice());
                System.out.println("총 수량 : " + orderGroup.getTotalQuantity());

                System.out.println("=============== 주문 상세 ===============");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
                });
            });
        }

        Assert.assertNotNull(user);
    }

    public void update(){

        Optional<User> user = userRepository.findById(2L); // Optional로 return 시켜줘야 한다.

        user.ifPresent(selectUser ->{ //Optional로 값을 받으면 값이 있으면 실행시키다. (없을수도 있기 때문)
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }


    @Transactional // 쿼리는 실행되지만 데이터는 그대로 남아있게 한다. (RollBack 기능)
    public void delete(){

        Optional<User> user = userRepository.findById(2L); // Optional로 return 시켜줘야 한다.

        Assert.assertTrue(user.isPresent()); //반드시 값이 있어야 통과된다.

        user.ifPresent(selectUser ->{ //Optional로 값을 받으면 값이 있으면 실행시키다. (없을수도 있기 때문)
            userRepository.delete(selectUser);
        });

        Optional<User> deleteuser = userRepository.findById(2L); // Optional로 return 시켜줘야 한다.

        Assert.assertFalse(deleteuser.isPresent()); // 반드시 값이 없어야 통과된다.
    }

}