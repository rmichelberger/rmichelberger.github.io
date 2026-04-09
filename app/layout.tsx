import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "Jean.works — Stop chatting. Start doing.",
  icons: {
     icon: "https://jean.works/images/app-icon.png",
     apple: "https://jean.works/images/app-icon.png"
  },
  description:
    "Privacy-first AI assistant with tools, custom agents, and multi-provider support. No account required. Your data stays on your device.",
  keywords: [
    "AI assistant",
    "mobile AI",
    "privacy",
    "local-first",
    "Gemini",
    "OpenAI",
    "Anthropic",
    "custom agents",
    "tools",
    "iOS",
    "Android",
  ],
  authors: [{ name: "Roland Michelberger" }],
  openGraph: {
    title: "Jean.works — Stop chatting. Start doing.",
    description:
      "Privacy-first AI assistant with tools, custom agents, and multi-provider support.  It doesn't just talk, it get things done. No account required. Your data stays on your device.",
    url: "https://jean.works",
    siteName: "Jean.works",
    type: "website",
    locale: "en_US",
    images: [{ url: "https://jean.works/images/og-image.png" }]
  },
  twitter: {
    card: "summary_large_image",
    title: "Jean.works — Stop chatting. Start doing.",
    description:
      "Privacy-first AI assistant with tools, custom agents, and multi-provider support.  It doesn't just talk, it get things done. No account required. Your data stays on your device.",
    images: "https://jean.works/images/og-image.png",
  },
  metadataBase: new URL("https://jean.works"),
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html
      lang="en"
      className={`${geistSans.variable} ${geistMono.variable} h-full antialiased`}
    >
      <body className="min-h-full flex flex-col">{children}</body>
    </html>
  );
}
