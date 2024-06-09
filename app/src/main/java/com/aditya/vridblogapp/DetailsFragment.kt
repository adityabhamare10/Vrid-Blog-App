package com.aditya.vridblogapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

class DetailsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView: WebView = view.findViewById(R.id.web_view)
        var content = arguments?.getString("content")

        Log.d("DetailsFragment", "Content received: $content")

        content = """
             <html>
            <head>
                <style>
                    body {
                        font-size: 35px;
                        padding-left: 20px;
                        padding-right: 20px;
                        line-height: 1.6;
                    }
                    img {
                        width: 100%;
                        height: auto;
                    }
                </style>
            </head>
            <body>
                ${content ?: ""}
            </body>
            </html>
        """

        webView.settings.apply {
            javaScriptEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            domStorageEnabled = true
            defaultFontSize = 40
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("DetailsFragment", "Page loaded: $url")
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                Log.e("DetailsFragment", "Error loading page: $description")
            }
        }

        if (content != null) {
            webView.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null)
        } else {
            Log.e("DetailsFragment", "Content is null")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

