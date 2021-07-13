from flask import Flask,request,jsonify,render_template
from flask_cors import CORS,cross_origin
import requests
import base64

app=Flask(__name__)
CORS(app)

@app.route("/images",methods=["POST"])
@cross_origin()
def processImage():
    image=request.json
    imagestart=image["images"].index("64,")
    imagestart=imagestart+3
    imagevalue=image["images"][imagestart:]
    image["images"]=imagevalue
    print(image)
    headers={"Content-Type":"application/json"}
    #os.environ["GCP_URL"]
    resp = requests.post(url="http://gcpimageprocess:5000/imagesToDetect",headers=headers,json=image)
    jsonpayload=resp.json()#file=request.files['image']
    max=0
    letter="P"
    for items in jsonpayload["payload"]:
        scorevalue=items["classification"]["score"]
        if scorevalue > max:
            max=scorevalue
            letter=items["displayName"]
    value=""
    print(letter)     
    if letter == "P":
        value="PRODUCT"
        #f=open("productdetails.jpg","r")
        #imgread=f.read()
        #imgbase64=base64.encodebytes(imgread)
    elif letter == "V":
        value="ACCOUNTSUMMARY"
        
    headers["key"]=value
    #os.environ["SUMMARY_API"]
    resp=requests.get(url="http://springbootapp:8090/getsummary",headers=headers)
    print(resp.json())
    details={}
    #details['textresponse']=resp.json()
    #if imgbase64 is not None:
    #  details['img']=imgbase64
    #print(details)
    return jsonify(resp.json())

@app.route("/header")
def header():
    return render_template("Header.html")

@app.route("/footer")
def footer():
    return render_template("Footer.html")

@app.route("/signlanguage")
def imageOrch():
    return render_template("SignLanguage.html")

@app.route("/")
@app.route("/home")
def home():
    return render_template("main.html")

if __name__=="__main__":
    app.run(debug=True,host='0.0.0.0',port=5001)
