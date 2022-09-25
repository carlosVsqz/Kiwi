import React from 'react';
import Link from 'next/link';
import {PostItem} from '@store/slices/posts';
import {ArchiveItem} from "@store/slices/archive";

const PostCoverDoc = ({ data }: { data: ArchiveItem }) => {
  return (
    <Link href="/p/archivo/[id]" as={'/p/archivo/' + data.id}>
      <a href={'/p/archivo/' + data.id} className="card-cover">
        <img src={data.image as string} alt="card cover" />
      </a>
    </Link>
  );
};
export default PostCoverDoc;
