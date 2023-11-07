# -*- coding: utf-8 -*-
import json
import requests
from flask_cors import CORS
from flask import Flask, render_template ,request, jsonify

app = Flask(__name__)
CORS(app)

NAVER_CLIENT_ID = 'ugZJpWLTI5E5CLAVmEZ6'
NAVER_CLIENT_SECRET = '2A7McIdvhC'
# 메인페이지
@app.route('/')
def index():
    return render_template('news.html')

@app.route('/news', methods=['GET'])
def get_news():
    print(request)
    query = request.args.get('query')
    print(query)
    url = f'https://openapi.naver.com/v1/search/news.json?query={query}'
    headers = {
        'X-Naver-Client-Id': NAVER_CLIENT_ID,
        'X-Naver-Client-Secret': NAVER_CLIENT_SECRET,
    }
    response = requests.get(url, headers=headers)
    data = response.json()
    return jsonify(data)


def fetch_naver_news(search_query):
    # 검색어를 사용하여 네이버 뉴스 API에서 데이터를 가져오는 코드입니다.
    url = f'https://openapi.naver.com/v1/search/news.json?query={search_query}'
    headers = {
        'X-Naver-Client-Id': NAVER_CLIENT_ID,  # 네이버 API 클라이언트 ID
        'X-Naver-Client-Secret': NAVER_CLIENT_SECRET,  # 네이버 API 클라이언트 시크릿
    }
    response = requests.get(url, headers=headers)
    data = response.json()

    # 가져온 데이터를 JSON 형식으로 반환합니다.
    return data


if __name__ == '__main__':
    app.run(debug=True)

