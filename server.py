import asyncio
import websockets
import json
import os

# for filename in os.listdir('data'):
#     if filename == 'Jungle_Speed.txt':
#         continue
#     f = open('data/'+filename, encoding="utf8")
#     s = f.read()
#     f.close()

def request(Name,Ages):
    f = open('data/requestbase.json', 'r')
    s = f.read()
    s = json.loads(s)
    requests = s['requests']
    requests.append({'name':Name, 'ages':Ages})
    f.close()

    print(s)
    
    f = open('data/requestbase.json', 'w')
    f.write(json.dumps(s))
    f.close()

def register(Regusername,Regpassword):
    f = open('data/database.json', 'r')

    s = f.read()
    s = json.loads(s)

    print (s['users'])

    users = s['users']
    users.append({'username':Regusername, 'password':Regpassword})

    print(users)

    f.close()

    print(s)
    
    f = open('data/database.json', 'w')
    f.write(json.dumps(s))
    f.close()
#   await ws.send('User Registered Succesfully')
    

def check_user(username, password):
    f = open('data/database.json', 'r')
    s = f.read()
    s = json.loads(s)

    users = s['users']
    for user in users:
        if user['username'] == username:
            if user['password'] == password:
                f.close()
                return True

    f.close()
    return False

async def mainloop(ws, path):
    command = await ws.recv()
    print(command)

    if command == 'login':
        user = await ws.recv()
        user = json.loads(user)
        print(user)

        if check_user(user['username'], user['password']):
            print('correct')
            await ws.send('true')
            print('works')
        else:
            print('incorrect')
            await ws.send('false')
    if command == 'register':
        username = await ws.recv()
        password = await ws.recv()
        register(username, password)

    if command == 'request':
        name = await ws.recv()
        ages = await ws.recv()
        request(name,ages)

start_server = websockets.serve(mainloop, '10.0.0.46', 8080)

asyncio.get_event_loop().run_until_complete(start_server)
asyncio.get_event_loop().run_forever()