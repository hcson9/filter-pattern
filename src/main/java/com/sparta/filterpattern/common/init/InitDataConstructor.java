package com.sparta.filterpattern.common.init;

import com.sparta.filterpattern.product.model.Category;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.model.YN;
import com.sparta.filterpattern.product.service.ProductServiceImpl;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class InitDataConstructor {

  private final ProductServiceImpl productServiceImpl;

  @PostConstruct
  @Transactional
  public void init() {
    List<Product> productList =
        List.of(new Product("어센틱 44 DX - (애너하임 팩토리) 블루",
                45990D, Category.SHOES, YN.Y),



            new Product("[이서 착용] 2color 여 슬림핏 인스티튜셔널 로고 반팔 티셔츠 (화이트블랙)",
                52000D, Category.PANTS, YN.N),



            new Product("[무료반품] Honey Teddy 피그먼트 반팔티 스모크블랙",
                50000D, Category.SHIRTS, YN.N),



            new Product("심볼 에어 머슬핏 숏 슬리브 4 color",
                22000D, Category.SHIRTS, YN.N),



            new Product("릴렉스 핏 크루 넥 반팔 티셔츠 2팩",
                31800D, Category.SHIRTS, YN.N),



            new Product("애플워치 8/7/6/5/4/3/2/SE 세대 밀레니즈 스트랩 투명 TPU밴드 41mm/40mm/38mm",
                5000D, Category.ACCESSORY, YN.N),


            new Product("라이트웨이트 크루 삭스 7팩 [화이트]",
                19900D, Category.ACCESSORY, YN.N),



            new Product("알파바운스 슬라이드 - 블랙:화이트 / BA8775",
                43104D, Category.SHOES, YN.Y),



            new Product("[무료반품] 사이드 턱 스냅 버튼 와이드 데님 팬츠 (BLUE GRAY)",
                28688D, Category.PANTS, YN.N),



            new Product("[무료반품] [ORO Package]오로 레이어드 스웰 핸드백_Rose Pink",
                46000D, Category.ACCESSORY, YN.Y));


    for (Product product : productList) {
      productServiceImpl.save(product);
    }
  }
}
