dic = {"a":1, "b":2}
print(dic["a"])
dic["c"] = 3
dic["a"] = 4
print(type(dic))
del dic["b"]
for key,value in dic.items():
    print("key: ", key, " value: ", value)

dic2 = {"Nam":"Apple", "Mai":"Banana", "Nga":"xiaomi", "Lan":"Oppo"}

for key, value in dic2.items():
    print("key: ", key, " value: ", value)
    print(f"{key.upper()} like smartphone of {value.lower()}")

print("values")
for value in set(dic2.values()):
    print(value)

print("keys", 12**0.5)