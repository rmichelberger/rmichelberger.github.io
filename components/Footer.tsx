import Image from "next/image";
import Link from "next/link";

export default function Footer() {
  return (
    <footer className="border-t border-border py-12 px-6">
      <div className="mx-auto max-w-6xl flex flex-col sm:flex-row items-center justify-between gap-6">
        {/* Logo */}
        <div className="flex items-center gap-2">
          <Image
            src="/images/logo.png"
            alt="Jean logo"
            width={24}
            height={24}
            className="rounded-md"
          />
          <span className="text-sm">
            <span className="font-bold">jean</span>
            <span className="text-muted-foreground">.works</span>
          </span>
        </div>

        {/* Links */}
        <div className="flex items-center gap-6 text-sm text-muted-foreground">
          <Link href="/privacy" className="hover:text-foreground transition-colors">
            Privacy Policy
          </Link>
          <a
            href="mailto:roland.michelberger@protonmail.ch"
            className="hover:text-foreground transition-colors"
          >
            Contact
          </a>
        </div>

        {/* Copyright */}
        <p className="text-sm text-muted-foreground">
          © {new Date().getFullYear()} Roland Michelberger
        </p>
      </div>
    </footer>
  );
}
