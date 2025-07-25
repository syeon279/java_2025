import json, os, csv, platform
import pandas as pd     # 데이터분석
import matplotlib.pyplot as plt   # 그래프
from selenium import webdriver    # 크롤링 - 웹페이지에 정보가져오기
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup   # html 원하는 정보를 추출

# pip install requests    
# pip install selenium beautifulsoup4 matplotlib pandas
# python -m  pip install requests 

##### 한글폰트 깨짐방지 설정
if platform.system() == "Windows":
    plt.rcParams["font.family"] = "Malgun Gothic"
elif platform.system() == "Darwin":
    plt.rcParams["font.family"] = "AppleGothic"
else:
    plt.rcParams["font.family"] = "NanumGothic"  # 리눅스: 설치 필요
plt.rcParams["axes.unicode_minus"] = False



# 🔹 1. 기본계좌클래스
# 상태 : id, pw, balance / 행위 : deposit , withraw , to_dict
class  Account:
  def __init__(self , id, pw, balance=0):
    self.id = id
    self.pw = pw
    self.balance=balance
  
  def deposit(self, amount) : 
    self.balance  += amount
    print(f"✔️입금완료! 현재잔액 : {self.balance}")  
    
  def withdraw(self, amount) : 
    if self.balance >= amount : 
      self.balance  -= amount
      print(f"✔️출금완료! 현재잔액 : {self.balance}")  
    else : 
      print("❌ 잔액이 부족합니다.")  
      
  def  to_dict(self):
    return {"id":self.id , "pw" : self.pw  , "balance" : self.balance}
  
# 🔹 2. 프리미엄 계좌 (출금시 수수료 100)
class PremiumAccount(Account) :
  def withdraw(self, amount) : 
    fee = 100
    total = amount + fee
    if self.balance >= total : 
      self.balance  -= total
      print(f"✔️프리미엄 출금완료! (수수료 100 포함) 현재잔액 : {self.balance}")  
    else : 
      print("❌ 잔액이 부족합니다.(수수료 포함)")  

# my  = PremiumAccount("first" , "1111" , 1000)
# my.deposit(1000)
# my.withdraw(2500)
# my.withdraw(1200)




# 🔹 아이디 중복 검사 클래스
class AccountValidator:
    def __init__(self, accounts):
        self.accounts = accounts

    def is_duplicate(self, id):
        return any(acc.id == id for acc in self.accounts)


# 🔹 3. 은행시스템클래스
class BankSystem:
  # 파일계좌만들기
  def __init__(self):
    self.accounts = self.load_accounts()
  
  # 저장하기
  def  load_accounts(self) : 
    if os.path.exists("accouts.json") : 
      with open("accouts.json" , "r" ,encoding="utf-8") as f:
        data=json.load(f)
        return [PremiumAccount(acc["id"],acc["pw"],acc["balance"]) for acc in data ]
    return []  
  
  def  save_accounts(self) : 
      with open("accouts.json" , "w" ,encoding="utf-8") as f:
        json.dump([ acc.to_dict()  for acc in self.accounts ] , f ,   ensure_ascii=False , indent=2)
  
  # 계좌찾기
  def  find_account(self) : 
    id = input("➜ 아이디   : ")
    pw = input("➜ 비밀번호 : ")
    for acc in self.accounts : 
      if acc.id == id  and  acc.pw == pw : 
        return acc
    return None  
  
  """
  # 1.계좌 추가
  def add_account(self) : 
    print("🧿 계좌추가")
    id = input("➜ 아이디   : ")
    pw = input("➜ 비밀번호 : ")
    balance = float(input("➜ 초기잔액 : "))
    acc = PremiumAccount(id,pw, balance)
    self.accounts.append(acc)
    self.save_accounts()
    print("✔️ 프리미엄 계좌가 등록되었습니다.")
  """
  def add_account(self):
    print("🧿 계좌추가")
    id = input("➜ 아이디   : ")
    # 중복 검사
    validator = AccountValidator(self.accounts)
    if validator.is_duplicate(id):
        print("❌ 이미 사용 중인 아이디입니다. 다른 아이디를 입력해주세요.")
        return
    
    pw = input("➜ 비밀번호 : ")
    balance = float(input("➜ 초기잔액 : "))
    acc = PremiumAccount(id, pw, balance)
    self.accounts.append(acc)
    self.save_accounts()
    print("✔️ 프리미엄 계좌가 등록되었습니다.")
  
    
  # 2.계좌조회
  def view_account(self) : 
    print("🧿 계좌조회")
    acc = self.find_account()
    if acc : 
      print(f"✔️ 계좌정보 - ID :{acc.id} , 잔액 : {acc.balance}")
    else : 
      print(f"❌ 계좌를 찾을 수 없습니다.")
        
  # 3.입금
  def deposit(self) : 
    print("🧿 입금")
    acc = self.find_account()
    if acc : 
      amount = float(input("➜ 입금 금액: "))
      acc.deposit(amount)
      self.save_accounts() 
    else : 
      print(f"❌ 계좌를 찾을 수 없습니다.")
        
  # 4.출금
  def withdraw(self) : 
    print("🧿 출금")
    acc = self.find_account()
    if acc : 
      amount = float(input("➜ 출금 금액: "))
      acc.withdraw(amount)
      self.save_accounts() 
    else : 
      print(f"❌ 계좌를 찾을 수 없습니다.")
  
  # 5.계좌삭제
  def delete_account(self):
    print("🧿 계좌삭제")
    acc = self.find_account()
    if acc : 
      self.accounts.remove(acc)
      self.save_accounts() 
      print("✔️ 계좌가 삭제되었습니다.")
    else : 
      print(f"❌ 계좌를 찾을 수 없습니다.")
      
  # 6.금리 추천보기
  def show_rates(self) : 
    print("🧿 현재 인기 예금금리를 불러오는 중입니다. \n")
    # 크롤링
    options = Options() # 크롬 브라우저 실행옵션을 설정하는 객체
    options.add_argument("--headless") #백그라운드에서 실행
    driver = webdriver.Chrome(options=options) # 크롬 웹 브라우저 실행
    driver.get("http://nblue.kr/") #해당 url로 접속

    WebDriverWait(driver, 10).until( #웹페이지 로딩 기다리는 코드 - 10초동안 최대로딩 기다리기
        EC.presence_of_element_located((By.TAG_NAME, "table")) #TABLE 태그 등장할때까지 
    )

    soup = BeautifulSoup(driver.page_source, "html.parser") #HTML 태그 전체가져오기
    driver.quit() # 드라이버 닫기

    bank_list = [] 
    for row in soup.select("table tr"):
        cols = row.find_all("td")
        if len(cols) >= 3:
            bank = cols[0].text.strip()
            product = cols[1].text.strip()
            rate = cols[2].text.strip()
            # rate %있는지 확인, 앞뒤 공백 제거하고 첫번째 글자가 숫자인지
            # " 50% "             "50%"           "%"     True
            if "%" in rate and rate.strip()[0].isdigit() :
                bank_list.append({
                    "은행" : bank,
                    "상품명" : product,
                    "금리" : rate
                })
    #print(bank_list)
    # [분석] 금리정보저장
    with open("rates.csv", "w", encoding="utf-8", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=["은행", "상품명", "금리"])
        writer.writeheader()
        writer.writerows(bank_list)
        
    # [분석] 제일 높은 금리 top3
    print("[분석] 제일 높은 금리 top3")
    top3 = sorted(bank_list, key=lambda x : float(x["금리"].replace("%","")), reverse=True)[:3]
    
    # with open("Bestrates.csv", "w", encoding="utf-8", newline="") as f:
    #     writer = csv.DictWriter(f, fieldnames=["은행", "상품명", "금리"])
    #     writer.writeheader()
    #     writer.writerows(top3)6
        
    for i, item in enumerate(top3, start=1):
        print(f"{i}. {item["은행"]} | {item["상품명"]} - {item["금리"]}")
    print()
    
    # [분석] 제일 낮은 금리 - 1개
    print("[분석] 제일 낮은 금리 상품")
    lowest = min(bank_list, key=lambda x: float(x["금리"].replace("%", "")))
    print(f"🧊 {lowest['은행']} | {lowest['상품명']} - {lowest['금리']}")
    print()
    
    # [분석] 평균 금리
    print("[분석] 전체 평균 금리")
    rates = [float(x["금리"].replace("%", "")) for x in bank_list]
    average = sum(rates) / len(rates)
    print(f"📊 평균 금리: {average:.2f}%")
    print()  
    
    # [분석] 금리 격차 분석
    print("[분석] 금리 격차 분석")
    gap = max(rates) - min(rates)
    print(f"📉 최고 금리와 최저 금리의 격차는 {gap:.2f}%입니다.")
    print()

    # [분석] 은행별 평균금리
    print("[분석] 은행별 평균 금리")
    from collections import defaultdict

    bank_rates = defaultdict(list)
    for item in bank_list:
        bank = item["은행"]
        rate = float(item["금리"].replace("%", ""))
        bank_rates[bank].append(rate)

    for bank, rate_list in bank_rates.items():
      avg = sum(rate_list) / len(rate_list)
      print(f"🏦 {bank} 평균 금리: {avg:.2f}%")
    print()
  
  # 7.금리 시각화차트
  def  show_graph(self) :
    print("\n\n🏦 금리 시각화차트 (TOP5)") 
    if not os.path.exists("rates.csv") :
      print("금리정보가 없습니다. 먼저 6. 금리 추천보기를 실행해보세요.")
      return
    #top5
    df = pd.read_csv("rates.csv")
    df["금리값"] = df["금리"].str.replace("%" , "").astype(float)  #금리값을 숫자형
    # 중복상품 제거 후 내림차순으로 정렬 상위 5개
    top5 = df.drop_duplicates(subset=["은행" , "상품명"]).sort_values("금리값" , ascending=False).head(5)
    # 수평 막대 그래프 그리기
    top5["라벨"] = top5["은행"] + "-" + top5["상품명"]
    plt.figure(figsize=(15, 6)) #그래프사이즈 가로 - 15/ 세로 6
    bars = plt.barh(top5["라벨"], top5["금리값"], color="cornflowerblue") # Y / X / 색상
    plt.xlabel("금리 (%)")    # X 축 레이블
    plt.title("TOP 5 예금 상품 금리 차트") # 상단 제목
    plt.gca().invert_yaxis()  # 금리가 높은 항목이 위쪽
    # 각 막대 끝에 금리값 표시
    for bar in bars:
        width = bar.get_width()
        plt.text(width + 0.1,              # X 위치 (막대 끝에서 조금 오른쪽)
                bar.get_y() + bar.get_height() / 2,   # Y 축
                f"{width:.2f}%",            # 표시 텍스트
                va="center", ha="left", fontsize=10)  
    plt.tight_layout()
    plt.show()
   
  # 8.은행별 평균금리 시각화차트
  def bank_graph(self) :
    print(f"\n\n📊 은행별 평균 금리 막대 그래프 ")
    if not os.path.exists("rates.csv") :
        print("금리정보가 없습니다. 먼저 6. 금리 추천보기를 실행해보세요.")
        return

    df = pd.read_csv("rates.csv")
    df["금리값"] = df["금리"].str.replace("%", "").astype(float)

    bank_avg = df.groupby("은행")["금리값"].mean().sort_values(ascending=False)

    plt.figure(figsize=(12, 6))
    bars = plt.bar(bank_avg.index, bank_avg.values, color="mediumseagreen")
    plt.ylabel("평균 금리 (%)")
    plt.title("📈 은행별 평균 금리")
    plt.xticks(rotation=45)

    for bar in bars:
        height = bar.get_height()
        plt.text(bar.get_x() + bar.get_width() / 2, height + 0.05,
                f"{height:.2f}%", ha="center", va="bottom", fontsize=10)

    plt.tight_layout()
    plt.show()
  
  
  def run(self):
    while True : 
      print("\n\n\n======BANK======" ,  "1. 계좌 추가" ,  "2. 계좌 조회" , "3. 입금" ,  "4. 출금" , "5. 계좌 삭제" ,   "6. 금리 추천보기" ,  "7. 금리 시각화차트" ,  "8. 은행별 평균금리 시각화차트" ,   "9. 종료" , sep="\n")
      choice=input("입력>>")
      if choice == "1" : 
        self.add_account()
      elif choice == "2" : 
        self.view_account()
      elif choice == "3" : 
        self.deposit()
      elif choice == "4" : 
        self.withdraw()
      elif choice == "5" : 
        self.delete_account()
      elif choice == "6" : 
        self.show_rates()
      elif choice == "7" : 
        self.show_graph()
      elif choice == "8" : 
        self.bank_graph()
      elif choice == "9" : 
        print("👋 종료합니다.")
        break
      else:
          print("❗ 유효한 메뉴 번호를 입력해주세요.")

# 🔹 4.프로그램실행
if __name__ == "__main__" : 
  app  = BankSystem()
  app.run()