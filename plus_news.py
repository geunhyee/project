# -*- coding: utf-8 -*-
import json
import requests
from flask_cors import CORS
from flask import Flask, render_template, request, jsonify

app = Flask(__name__)
CORS(app)

NAVER_CLIENT_ID = 'ugZJpWLTI5E5CLAVmEZ6'
NAVER_CLIENT_SECRET = '2A7McIdvhC'
KAKAO_REST_API_KEY = 'd0f786cef81189455df44475d58e7054'


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/plus_news', methods=['GET'])
def get_news():
    query = request.args.get('query')
    naver_data = fetch_naver_news(query)
    kakao_data = fetch_kakao_news(query)

    # 두 API에서 가져온 데이터를 합칩니다.
    combined_data = {
        'naver_news': naver_data,
        'kakao_news': kakao_data
    }

    user_query = query
    naver_articles = [article['title'] for article in naver_data['items']]
    kakao_articles = [article['title'] for article in kakao_data['documents']]

    naver_similarities = calculate_similarity(user_query, naver_articles)
    kakao_similarities = calculate_similarity(user_query, kakao_articles)

    # 유사도 데이터를 combined_data에 추가
    combined_data['naver_similarities'] = naver_similarities.tolist()
    combined_data['kakao_similarities'] = kakao_similarities.tolist()

    return jsonify(combined_data)





def fetch_naver_news(query):
    print(query)
    url = f'https://openapi.naver.com/v1/search/news.json?query={query}'
    headers = {
        'X-Naver-Client-Id': NAVER_CLIENT_ID,
        'X-Naver-Client-Secret': NAVER_CLIENT_SECRET,
    }
    response = requests.get(url, headers=headers)
    data = response.json()
    return data


def fetch_kakao_news(query):
    url = f'https://dapi.kakao.com/v2/search/web?query={query}'
    headers = {
        'Authorization': f'KakaoAK {KAKAO_REST_API_KEY}'
    }
    response = requests.get(url, headers=headers)
    data = response.json()
    return data

# 단어 유사성
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity

def calculate_similarity(query, articles):
    tfidf_vectorizer = TfidfVectorizer()
    article_tfidf = tfidf_vectorizer.fit_transform(articles)
    query_tfidf = tfidf_vectorizer.transform([query])
    similarities = cosine_similarity(query_tfidf, article_tfidf)
    return similarities[0]


if __name__ == '__main__':
    app.run(debug=True)
