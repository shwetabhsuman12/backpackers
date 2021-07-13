from flask import Flask,jsonify,request,render_template
import requests
import json
import os
app=Flask(__name__)

@app.route("/imagesToDetect",methods=["POST"])
def processImage():
    imagejson=request.json
    
    image={}
    image['imageBytes']=imagejson['images']
    payload={}
    payload['image']=image
    datavalue={}
    datavalue['payload']=payload
    headers={"Content-Type":"application/json"}
    headers["Authorization"]="Bearer "+ os.environ["imgbytes"]
    print(headers)
    print(request.json)
    resp=requests.post(url="https://automl.googleapis.com/v1beta1/projects/677451147416/locations/us-central1/models/ICN3550918981390958592:predict",headers=headers,json=datavalue)
    print(resp.json())
    return resp.json()

if __name__=="__main__":
    app.run(host='0.0.0.0')