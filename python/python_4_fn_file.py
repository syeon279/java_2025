# 1. 함수
# 마법상자 - 어떤 것을 넣으면, 약속한 결과를 돌려줌

def hi(name) : 
    return f"안녕 {name}님"

print( hi("소현"))

# 1-1. ex
def animal(동물) :
    if 동물 == "강아지":
        return "멍멍~"
    elif 동물 == "고양이":
        return "야옹~"
    else :
        return "..."
print(animal("카피바라"))
print(animal("고양이"))
print(animal("강아지"))

# 2. 파일 입출력 with(안정장치) open 옵션(read / write)
with open('frutes.txt','w', encoding='utf-8') as f :
    f.write("apple\nbanana\n")
    
    with open('frutes.txt','r', encoding='utf-8') as f :
        print(f.read())