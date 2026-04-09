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
  title: "Jean — AI Assistant for iOS & Android",
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
    title: "Jean — AI Assistant for iOS & Android",
    description:
      "Privacy-first AI assistant with tools, custom agents, and multi-provider support. No account required. Your data stays on your device.",
    url: "https://jean.works",
    siteName: "Jean",
    type: "website",
    locale: "en_US",
  },
  twitter: {
    card: "summary_large_image",
    title: "Jean — AI Assistant for iOS & Android",
    description:
      "Privacy-first AI assistant with tools, custom agents, and multi-provider support.",
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
