import os, platform, time
import pandas as pd
import matplotlib.pyplot as plt
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

##### 한글폰트 설정
if platform.system() == "Windows":
    plt.rcParams["font.family"] = "Malgun Gothic"
elif platform.system() == "Darwin":
    plt.rcParams["font.family"] = "AppleGothic"
else:
    plt.rcParams["font.family"] = "NanumGothic"
plt.rcParams["axes.unicode_minus"] = False

# 🔹 여행지 클래스
class Place:
    def __init__(self, name, category, rating):
        self.name = name
        self.category = category
        self.rating = rating

    def to_dict(self):
        return {"여행지": self.name, "카테고리": self.category, "평점": self.rating}


# 🔹 TripPaw 여행 데이터 시스템
class TripPawSystem:
    def __init__(self):
        self.places = []

    # 1. 여행지 크롤링 (카카오맵)
    def crawl_places(self, region, category):
        keyword = f"{region}강아지동반{category}"
        print(f"🧿 '{keyword}' 크롤링 중...\n")

        options = Options()
        options.add_argument("--headless")
        driver = webdriver.Chrome(options=options)
        driver.get(f"https://map.kakao.com/?q={keyword}")
        time.sleep(3)  # 페이지 로딩 대기

        # 장소명 수집
        place_elements = driver.find_elements(By.CSS_SELECTOR, "a.link_name")
        collected = 0
        for p in place_elements[:10]:  # 상위 10개만
            name = p.text.strip()
            if name:
                rating = round(3.5 + (hash(name) % 15) / 10, 1)  # 임시 평점
                self.places.append(Place(name, category, rating))
                collected += 1

        driver.quit()
        print(f"✔️ {collected}개 여행지 데이터 수집 완료\n")

    # 2. CSV 저장
    def save_to_csv(self, filename="places.csv"):
        if not self.places:
            print("❌ 저장할 데이터가 없습니다. 먼저 크롤링을 진행하세요.\n")
            return
        df = pd.DataFrame([p.to_dict() for p in self.places])
        df.to_csv(filename, index=False, encoding="utf-8-sig")
        print(f"💾 '{filename}' 파일로 저장 완료\n")

    # 3. 인기 여행지 TOP5 그래프
    def show_top5_graph(self):
        if not self.places:
            print("❌ 여행지 데이터가 없습니다. 먼저 크롤링을 진행하세요.\n")
            return

        df = pd.DataFrame([p.to_dict() for p in self.places])
        top5 = df.sort_values("평점", ascending=False).head(5)

        plt.figure(figsize=(10, 5))
        bars = plt.barh(top5["여행지"], top5["평점"], color="cornflowerblue")
        plt.xlabel("평점")
        plt.title("TripPaw 인기 여행지 TOP5")
        plt.gca().invert_yaxis()

        for bar in bars:
            width = bar.get_width()
            plt.text(width + 0.05, bar.get_y() + bar.get_height()/2,
                     f"{width:.1f}", va="center")

        plt.tight_layout()
        plt.show()

    # 4. 카테고리별 평균 평점 그래프
    def show_category_avg_graph(self):
        if not self.places:
            print("❌ 여행지 데이터가 없습니다. 먼저 크롤링을 진행하세요.\n")
            return

        df = pd.DataFrame([p.to_dict() for p in self.places])
        avg_df = df.groupby("카테고리")["평점"].mean().sort_values(ascending=False)

        plt.figure(figsize=(6, 4))
        bars = plt.bar(avg_df.index, avg_df.values, color="mediumseagreen")
        plt.ylabel("평균 평점")
        plt.title("카테고리별 평균 평점")

        for bar in bars:
            height = bar.get_height()
            plt.text(bar.get_x()+bar.get_width()/2, height+0.05,
                     f"{height:.2f}", ha="center", va="bottom")

        plt.tight_layout()
        plt.show()

    # 5. 프로그램 실행
    def run(self):
        while True:
            print("\n====== TripPaw 여행지 분석 메뉴 ======")
            print("1. 여행지 데이터 수집")
            print("2. CSV로 저장")
            print("3. 인기 여행지 TOP5 그래프")
            print("4. 카테고리별 평균 평점 그래프")
            print("5. 종료")
            choice = input("메뉴 선택 >> ")

            if choice == "1":
                region = input("➜ 지역 입력 (예: 서울, 부산): ")
                category = input("➜ 카테고리 입력 (예: 카페, 공원, 펜션): ")
                self.crawl_places(region, category)
            elif choice == "2":
                self.save_to_csv()
            elif choice == "3":
                self.show_top5_graph()
            elif choice == "4":
                self.show_category_avg_graph()
            elif choice == "5":
                print("👋 프로그램을 종료합니다.")
                break
            else:
                print("❌ 올바른 메뉴 번호를 입력해주세요.\n")


# 🔹 실행
if __name__ == "__main__":
    app = TripPawSystem()
    app.run()
