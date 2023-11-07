# -*- coding: utf-8 -*-
import json
import requests
from flask_cors import CORS

from flask import Flask, render_template ,request, jsonify

app = Flask(__name__)
CORS(app)

KAKAO_REST_API_KEY = 'd0f786cef81189455df44475d58e7054'


@app.route('/')
def index():
    return render_template('kakao_news.html')


@app.route('/kakao_news', methods=['GET'])
def get_kakao_news():
    print(request)
    query = request.args.get('query')
    print(query)
    url = f'https://dapi.kakao.com/v2/search/web?query={query}'
    headers = {
        'Authorization': f'KakaoAK {KAKAO_REST_API_KEY}'

    }
    response = requests.get(url, headers=headers)
    data = response.json()
    return jsonify(data)



if __name__ == '__main__':
    app.run(debug=True)

